package dgtic.proyecto.controller.carrito;

import dgtic.proyecto.dto.UsuarioDTO;
import dgtic.proyecto.exception.UsuarioNotFoundException;
import dgtic.proyecto.model.entities.*;
import dgtic.proyecto.service.carrito.CarritoService;
import dgtic.proyecto.service.domicilio.DomicilioService;
import dgtic.proyecto.service.metodopago.MetodoPagoService;
import dgtic.proyecto.service.producto.ProductoService;
import dgtic.proyecto.service.ticket.TicketService;
import dgtic.proyecto.service.ticketdetalle.TicketDetalleService;
import dgtic.proyecto.service.usuario.UsuarioService;
import dgtic.proyecto.util.RenderPagina;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "carrito")
@SessionAttributes("carrito")
public class CarritoController {
    @Autowired
    CarritoService carritoService;

    @Autowired
    ProductoService productoService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TicketDetalleService ticketDetalleService;

    @Autowired
    DomicilioService domicilioService;

    @Autowired
    MetodoPagoService metodoPagoService;

    @GetMapping("alta-carrito")
    public String altaCarrito(Model model){
        Carrito carrito = new Carrito();
        List<Producto> selectProducto = productoService.buscarProducto();
        List<Ticket> selectTicket = ticketService.buscarTicket();

        model.addAttribute("contenido","Alta de un Carrito");
        model.addAttribute("carrito",carrito);
        model.addAttribute("selectProducto", selectProducto);
        model.addAttribute("selectTicket", selectTicket);
        return "carrito/alta-carrito";
    }

    @PostMapping("salvar-carrito")
    public String salvarObjectThymeleaf(@Valid @ModelAttribute("carrito") Carrito carrito, BindingResult result,
                                        Model model, RedirectAttributes flash,
                                        SessionStatus sesion) {
        List<Producto> selectProducto = productoService.buscarProducto();
        List<Ticket> selectTicket = ticketService.buscarTicket();
        model.addAttribute("selectProducto",selectProducto);
        model.addAttribute("selectTicket",selectTicket);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en la entrada de datos");
            return "carrito/alta-carrito";
        }
        carritoService.guardar(carrito);
        sesion.setComplete();
        flash.addAttribute("success","Producto se almacenó con éxito");
        return "carrito/alta-carrito";
    }

    @GetMapping("lista-carrito")
    public String listaCarrito(@RequestParam(name="page",defaultValue = "0")int page,
                            Model model){
        Pageable pagReq= PageRequest.of(page,15);
        Page<Carrito> carritoEntities = carritoService.buscarCarrito(pagReq);
        RenderPagina<Carrito> render = new RenderPagina<>("lista-carrito",carritoEntities);
        model.addAttribute("carrito",carritoEntities);
        model.addAttribute("page",render);
        model.addAttribute("contenido","Lista de los Carritos");
        return "carrito/lista-carrito";
    }

    @GetMapping("modificar-carrito/{id}")
    public String carritoModificar(@PathVariable("id") Integer id,Model model){
        List<Producto> producto = productoService.buscarProducto();
        List<Ticket> ticket = ticketService.buscarTicket();
        Carrito carrito = carritoService.buscarCarritoId(id);
        model.addAttribute("selectProducto",producto);
        model.addAttribute("selectTicket",ticket);
        model.addAttribute("carrito",carrito);
        model.addAttribute("contenido","Modificar Carrito");
        return "carrito/alta-carrito";
    }

    @GetMapping("eliminar-carrito/{id}")
    public String eliminarCarrito(@PathVariable("id") Integer id,RedirectAttributes flash){
        carritoService.borrar(id);
        flash.addFlashAttribute("success","Se borró con éxito Carrito");
        return "redirect:/carrito/lista-carrito";
    }

    @PostMapping("/agregar")
    public String agregarAlCarrito(@RequestParam("productoId") int productoId, @RequestParam("cantidad") int cantidad, Principal principal) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo((principal.getName()));
        Producto producto = productoService.buscarProductoId(productoId);

        if (producto == null || usuario == null) {
            return "redirect:/";
        }

        Carrito carrito = carritoService.buscarCarritoPorUsuarioYProducto(usuario.getId(), productoId);
        if (carrito != null) {
            carrito.setCantidad(carrito.getCantidad() + cantidad);
        } else {
            carrito = new Carrito();
            carrito.setUsuario(usuario);
            carrito.setProducto(producto);
            carrito.setCantidad(cantidad);
        }

        carritoService.guardar(carrito);
        return "redirect:/carrito/ver";
    }

    @GetMapping("/ver")
    public String verCarrito(Model model, Principal principal) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/";
        }

        model.addAttribute("carrito", carritoService.buscarCarritosPorUsuarioId(usuario.getId()));
        return "/carrito/ver-carrito";
    }

    @PostMapping("/actualizar")
    public String actualizarCantidad(@RequestParam("carritoId") int carritoId, @RequestParam("cantidad") int cantidad) {
        Carrito carrito = carritoService.buscarCarritoId(carritoId);
        if (carrito != null && cantidad > 0) {
            carrito.setCantidad(cantidad);
            carritoService.guardar(carrito);
        }
        return "redirect:/carrito/ver";
    }

    @PostMapping("/eliminar")
    public String eliminarDelCarrito(@RequestParam("carritoId") int carritoId) {
        carritoService.borrar(carritoId);
        return "redirect:/carrito/ver";
    }

    @GetMapping("/modificar-domicilio")
    public String mostrarModificarDomicilio(Model model, Principal principal) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/";
        }

        Domicilio domicilio = domicilioService.buscarDomicilioPorUsuarioId(usuario.getId());
        if (domicilio == null) {
            domicilio = new Domicilio();
        }

        model.addAttribute("domicilio", domicilio);
        return "/carrito/modificar-domicilio";
    }

    @PostMapping("/actualizar-domicilio")
    public String actualizarDomicilio(@ModelAttribute("domicilio") Domicilio domicilio, Principal principal) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/";
        }

        domicilio.setUsuario(usuario);
        domicilioService.actualizarDomicilio(domicilio);

        return "redirect:/carrito/confirmar-compra";
    }

    @PostMapping("/confirmar-compra")
    public String confirmarCompra(Model model, Principal principal, HttpSession session) throws UsuarioNotFoundException {
        // Obtener el usuario actual
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/";
        }

        // Obtener el domicilio del usuario
        Domicilio domicilio = domicilioService.buscarDomicilioPorUsuarioId(usuario.getId());
        if (domicilio == null) {
            // Redirigir a la página para agregar un domicilio si no está registrado
            return "redirect:/domicilio/agregar";
        }

        // Obtener el carrito del usuario
        List<Carrito> carrito = carritoService.buscarCarritosPorUsuarioId(usuario.getId());
        if (carrito == null || carrito.isEmpty()) {
            return "redirect:/carrito/vacio";
        }

        // Generar Ticket de compra y calcula el total de compra
        Ticket ticket = new Ticket();
        ticket.setUsuario(usuario);
        ticket.setFecha_Compra(LocalDateTime.now());
        double totalCompra = carrito.stream()
                .mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad())
                .sum();
        ticket.setTotal_Compra(totalCompra);
        ticket.setMetodoPago(metodoPagoService.buscarMetodoPagoId(1));

        // Calcular la fecha de entrega entre 1 a 5 días
        int diasEntrega = (int) (Math.random() * 5) + 1; // Genera un número entre 1 y 5
        LocalDateTime fechaEntrega = ticket.getFecha_Compra().plusDays(diasEntrega);
        ticket.setFecha_Entrega(fechaEntrega);

        ticketService.guardar(ticket);

        // Generar TicketDetalle
        for (Carrito item : carrito) {
            TicketDetalle ticketDetalle = new TicketDetalle();
            ticketDetalle.setTicket(ticket);
            ticketDetalle.setProducto(item.getProducto());
            ticketDetalle.setCantidad(item.getCantidad());
            ticketDetalle.setPrecio(item.getProducto().getPrecio());
            ticketDetalleService.guardar(ticketDetalle);
        }

        // Borrar los productos del carrito
        //carritoService.borrarCarritoPorUsuarioId(usuario.getId());

        //Guarda el ticket en la sesión para utilizarlo después en caso de que se modifique el domicilio
        session.setAttribute("ticket", ticket);
        session.setAttribute("carrito", carrito);
        session.setAttribute("metodosPago", usuarioService.buscarMetodoPagoPorUsuarioId(usuario.getId()));
        session.setAttribute("usuario", usuario);

        // Agregar atributos al modelo para mostrar en la vista del resumen de compra
        model.addAttribute("ticket", ticket);
        model.addAttribute("detalles", ticketDetalleService.buscarTicketDetallePorTicketId(ticket.getId()));
        model.addAttribute("usuario", usuario);
        model.addAttribute("domicilio", domicilio);
        model.addAttribute("carrito", carrito); // Añadir carrito al modelo
        model.addAttribute("metodosPago", usuarioService.buscarMetodoPagoPorUsuarioId(usuario.getId()));

        return "/carrito/confirmar-compra";
    }

    @GetMapping("/confirmar-compra")
    public String mostrarConfirmarCompra(Model model, Principal principal, HttpSession session) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/";
        }

        Domicilio domicilio = domicilioService.buscarDomicilioPorUsuarioId(usuario.getId());
        if (domicilio == null) {
            domicilio = new Domicilio();
        }

        Ticket ticket = (Ticket) session.getAttribute("ticket");
        if (ticket == null){
            return "redirect:/";
        }

        List<Carrito> carrito = carritoService.buscarCarritosPorUsuarioId(usuario.getId());
        List<TicketDetalle> detalles = ticketDetalleService.buscarTicketDetallePorTicketId(ticket.getId());

        model.addAttribute("usuario", usuario);
        model.addAttribute("domicilio", domicilio);
        model.addAttribute("ticket", ticket);
        model.addAttribute("detalles", detalles);
        model.addAttribute("carrito", carrito);
        model.addAttribute("metodosPago", usuarioService.buscarMetodoPagoPorUsuarioId(usuario.getId()));
        return "/carrito/confirmar-compra";
    }

    @PostMapping("/confirmar-envio")
    public String confirmarEnvio(Model model, Principal principal, HttpSession session) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/";
        }
        Ticket ticket = (Ticket) session.getAttribute("ticket");
        if (ticket == null) {
            return "redirect:/";
        }
        Domicilio domicilio = domicilioService.buscarDomicilioPorUsuarioId(usuario.getId());
        // Aquí podrías añadir lógica para confirmar el envío
        model.addAttribute("usuario", usuario);
        model.addAttribute("ticket", ticket);
        model.addAttribute("mensaje", "Compra finalizada exitosamente.");
        // Borrar los productos del carrito
        carritoService.borrarCarritoPorUsuarioId(usuario.getId());
        return "/carrito/compra-finalizada";
    }


    @GetMapping("/compra-finalizada")
    public String mostrarCompraFinalizada() {
        return "/carrito/compra-finalizada";
    }
}
