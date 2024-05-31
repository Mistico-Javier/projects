package dgtic.proyecto.controller.metodopago;

import dgtic.proyecto.model.entities.MetodoPago;
import dgtic.proyecto.service.metodopago.MetodoPagoService;
import dgtic.proyecto.util.RenderPagina;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "metodoPago")
public class MetodoPagoController {
    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping("alta-metodoPago")
    public String altaMetodoPago(Model model){
        MetodoPago metodoPago = new MetodoPago();
        model.addAttribute("contenido","Alta de un Método de pago");
        model.addAttribute("metodoPago",metodoPago);
        return "metodoPago/alta-metodoPago";
    }
    @PostMapping("salvar-metodoPago")
    public String salvarMetodoPago(@Valid @ModelAttribute("producto") MetodoPago metodoPago,
                             Model model, RedirectAttributes flash){ // Redirección por lo tanto necesita un flash
        System.out.println(metodoPago);
        flash.addFlashAttribute("success","Método de pago se guardo con éxito");
        metodoPagoService.guardar(metodoPago);
        return "redirect:/inicio";
    }
    @GetMapping("lista-metodoPago")
    public String listaMetodoPago(@RequestParam(name="page",defaultValue = "0")int page,
                            Model model){
        Pageable pagReq= PageRequest.of(page,4);
        Page<MetodoPago> metodoPagoEntities = metodoPagoService.buscarMetodoPago(pagReq);
        RenderPagina<MetodoPago> render = new RenderPagina<>("lista-metodoPago",metodoPagoEntities);
        model.addAttribute("metodoPago",metodoPagoEntities);
        model.addAttribute("page",render);
        model.addAttribute("contenido","Lista de los métodos de pago");
        return "metodoPago/lista-metodoPago";
    }

    @GetMapping("modificar-metodoPago/{id}")
    public String metodoPagoModificar(@PathVariable("id") Integer id,Model model){
        MetodoPago metodoPago = metodoPagoService.buscarMetodoPagoId(id);
        model.addAttribute("metodoPago",metodoPago);
        model.addAttribute("contenido","Modificar método de pago");
        return "metodoPago/alta-metodoPago";
    }
    @GetMapping("eliminar-metodoPago/{id}")
    public String eliminarMetodoPago(@PathVariable("id") Integer id,RedirectAttributes flash){
        metodoPagoService.borrar(id);
        flash.addFlashAttribute("success","Se borró con éxito el método de pago");
        return "redirect:/metodoPago/lista-metodoPago";
    }
}
