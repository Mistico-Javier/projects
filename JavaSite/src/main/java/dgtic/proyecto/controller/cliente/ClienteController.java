package dgtic.proyecto.controller.cliente;

import dgtic.proyecto.model.entities.Cliente;
import dgtic.proyecto.model.entities.Domicilio;
import dgtic.proyecto.model.entities.MetodoPago;
import dgtic.proyecto.service.cliente.ClienteService;
import dgtic.proyecto.service.domicilio.DomicilioService;
import dgtic.proyecto.service.metodopago.MetodoPagoService;
import dgtic.proyecto.util.RenderPagina;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "cliente")
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    DomicilioService domicilioService;

    @Autowired
    MetodoPagoService metodoPagoService;

    @GetMapping("alta-cliente")
    public String altaCliente(Model model){
        Cliente cliente = new Cliente();
        List<Domicilio> selectDomicilio = domicilioService.buscarDomicilio();
        List<MetodoPago> selectMetodoPago = metodoPagoService.buscarMetodoPago();

        model.addAttribute("contenido","Alta de un Cliente");
        model.addAttribute("cliente",cliente);
        model.addAttribute("selectDomicilio", selectDomicilio);
        model.addAttribute("selectMetodoPago", selectMetodoPago);
        return "cliente/alta-cliente";
    }

    @PostMapping("salvar-cliente")
    public String salvarObjectThymeleaf(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result,
                                        Model model, RedirectAttributes flash,
                                        SessionStatus sesion) {
        List<Domicilio> selectDomicilio = domicilioService.buscarDomicilio();
        List<MetodoPago> selectMetodoPago = metodoPagoService.buscarMetodoPago();
        model.addAttribute("selectDomicilio",selectDomicilio);
        model.addAttribute("selectMetodoPago",selectMetodoPago);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en la entrada de datos");
            return "cliente/alta-cliente";
        }
        clienteService.guardar(cliente);
        sesion.setComplete();
        flash.addAttribute("success","Cliente se almacenó con éxito");
        return "cliente/alta-cliente";
    }

    @GetMapping("lista-cliente")
    public String listaCliente(@RequestParam(name="page",defaultValue = "0")int page,
                            Model model){
        Pageable pagReq= PageRequest.of(page,2);
        Page<Cliente> clienteEntities = clienteService.buscarCliente(pagReq);
        RenderPagina<Cliente> render = new RenderPagina<>("lista-cliente",clienteEntities);
        model.addAttribute("cliente",clienteEntities);
        model.addAttribute("page",render);
        model.addAttribute("contenido","Lista de los Clientes");
        return "cliente/lista-cliente";
    }

    @GetMapping("modificar-cliente/{id}")
    public String clienteModificar(@PathVariable("id") Integer id,Model model){
        List<Domicilio> domicilio = domicilioService.buscarDomicilio();
        List<MetodoPago> metodoPago = metodoPagoService.buscarMetodoPago();
        Cliente cliente = clienteService.buscarClienteId(id);
        model.addAttribute("selectDomicilio",domicilio);
        model.addAttribute("selectMetodoPago",metodoPago);
        model.addAttribute("cliente",cliente);
        model.addAttribute("contenido","Modificar Cliente");
        return "cliente/alta-cliente";
    }
    @GetMapping("eliminar-cliente/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id,RedirectAttributes flash){
        clienteService.borrar(id);
        flash.addFlashAttribute("success","Se borró con éxito Cliente");
        return "redirect:/cliente/lista-cliente";
    }
}
