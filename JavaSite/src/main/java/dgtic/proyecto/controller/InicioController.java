package dgtic.proyecto.controller;

import dgtic.proyecto.dto.RolDTO;
import dgtic.proyecto.dto.UsuarioDTO;
import dgtic.proyecto.exception.UsuarioNotFoundException;
import dgtic.proyecto.model.entities.*;
import dgtic.proyecto.security.jwt.JWTTokenProvider;
import dgtic.proyecto.security.request.JwtRequest;
import dgtic.proyecto.security.request.LoginUserRequest;
import dgtic.proyecto.service.carrito.CarritoService;
import dgtic.proyecto.service.domicilio.DomicilioService;
import dgtic.proyecto.service.metodopago.MetodoPagoService;
import dgtic.proyecto.service.tarjeta.TarjetaService;
import dgtic.proyecto.service.usuario.UsuarioService;
import dgtic.proyecto.service.usuariometodopagorelacion.UsuarioMetodoPagoRelacionService;
import dgtic.proyecto.system.service.AdminService;
import dgtic.proyecto.system.service.HomeService;
import dgtic.proyecto.system.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Controller
public class InicioController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    @Autowired
    private HomeService homeService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private DomicilioService domicilioService;

    @Autowired
    private MetodoPagoService metodoPagoService;

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private UsuarioMetodoPagoRelacionService usuarioMetodoPagoRelacionService;

    private final CarritoService carritoServiceUno;
    public InicioController(CarritoService carritoService){
        this.carritoServiceUno = carritoService;
    }

    @RequestMapping(value="/")
     public String home(Model model){
        model.addAttribute("text", homeService.getText());
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(Model model) {
        model.addAttribute("text", userService.getText());
        return "user";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(Model model) {
        model.addAttribute("text", adminService.getText());
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Login exitoso...");
        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        System.out.println("El inicio de sesión falló...");
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UsuarioDTO());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(UsuarioDTO user, Model model) throws UsuarioNotFoundException {
        user.setUseIdStatus(1);
        Set<RolDTO> roles = new HashSet<>();
        roles.add(RolDTO.builder().id(2).build());
        user.setUseRoles(roles);
        UsuarioDTO usuarioGuardado = usuarioService.save(user);

        // Redirigir a la página para registrar el domicilio
        model.addAttribute("userId", usuarioGuardado.getId());
        model.addAttribute("domicilio", new Domicilio());
        return "register_address";
    }

    @PostMapping("/process_register_address")
    public String processRegisterAddress(@ModelAttribute("domicilio") Domicilio domicilio, @RequestParam("userId") int userId, Model model) {
        // Guardar el domicilio asociado al usuario
        Usuario usuario = usuarioService.buscarUsuarioId(userId);
        domicilio.setUsuario(usuario);
        domicilioService.guardar(domicilio);

        model.addAttribute("userId", userId);
        model.addAttribute("metodosPago", metodoPagoService.buscarMetodoPago());
        // Redirigir a la página de registro de metodo de pago
        return "register_payment_method";
    }

    @PostMapping("/process_register_payment_method")
    public String processRegisterPaymentMethod(@RequestParam("userId") int userId, @RequestParam("metodoPagoId") int metodoPagoId, Model model, HttpSession session) {
        Usuario usuario = usuarioService.buscarUsuarioId(userId);
        MetodoPago metodoPago = metodoPagoService.buscarMetodoPagoId(metodoPagoId);

        UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion = new UsuarioMetodoPagoRelacion();
        usuarioMetodoPagoRelacion.setUsuario(usuario);
        usuarioMetodoPagoRelacion.setMetodoPago(metodoPago);

        // Guardar la relación entre usuario y método de pago
        usuarioMetodoPagoRelacionService.guardar(usuarioMetodoPagoRelacion);

        session.setAttribute("usuario",usuario);

        if (metodoPago.getMetodoPago().equals("Tarjeta de crédito") || metodoPago.getMetodoPago().equals("Tarjeta de débito")) {
            model.addAttribute("userId", userId);
            return "register_card";
        }
        return "register_success";
    }

    @PostMapping("/process_register_card")
    public String processRegisterCard(Tarjeta tarjeta, Principal principal, HttpSession session) throws UsuarioNotFoundException {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        //Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        tarjeta.setUsuario(usuario);
        tarjetaService.guardar(tarjeta);

        // registro de usuario exitoso
        return "register_success";
    }

    @PostMapping("/token")
    public String createAuthenticationToken(Model model, HttpSession session,
                                            @ModelAttribute LoginUserRequest loginUserRequest, HttpServletResponse res) throws Exception {
        log.info("LoginUserRequest {}", loginUserRequest);
        try {
            UsuarioDTO user = usuarioService.findByCorreo(loginUserRequest.getUsername());
            if (user.getUseIdStatus() == 1) {
                Authentication authentication = authenticate(loginUserRequest.getUsername(),
                        loginUserRequest.getPassword());
                log.info("authentication {}", authentication);
                String jwtToken = jwtTokenProvider.generateJwtToken(authentication, user);
                log.info("jwtToken {}", jwtToken);
                JwtRequest jwtRequest = new JwtRequest(jwtToken, user.getId(), user.getCorreo(),
                        jwtTokenProvider.getExpiryDuration(), authentication.getAuthorities());
                log.info("jwtRequest {}", jwtRequest);
                Cookie cookie = new Cookie("token",jwtToken);
                cookie.setMaxAge(Integer.MAX_VALUE);
                res.addCookie(cookie);
                session.setAttribute("msg","Login OK!");
            }
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            session.setAttribute("msg","Bad Credentials");
            return "redirect:/login";
        }
        return "redirect:/index";
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model, Principal principal) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/carrito/vacio"; // redirect:/carrito/vacio
        }

        List<Carrito> carrito = carritoServiceUno.buscarCarritosPorUsuarioId(usuario.getId());
        if (carrito == null || carrito.isEmpty()) {
            return "redirect:/carrito/vacio";
        }
        model.addAttribute("carrito", carrito);
        return "carrito";
    }

    @GetMapping("/carrito/vacio")
    public String carritoVacio(Model model) {
        return "carrito-vacio";
    }
}
