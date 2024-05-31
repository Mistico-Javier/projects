package dgtic.proyecto.controller.domicilio;

import dgtic.proyecto.model.entities.Domicilio;
import dgtic.proyecto.service.domicilio.DomicilioService;
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
@RequestMapping(value = "domicilio")
public class DomicilioController {
    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("alta-domicilio")
    public String altaDomicilio(Model model){
        Domicilio domicilio = new Domicilio();
        model.addAttribute("contenido","Alta de un Domicilio");
        model.addAttribute("domicilio",domicilio);
        return "domicilio/alta-domicilio";
    }
    @PostMapping("salvar-domicilio")
    public String salvarDomicilio(@Valid @ModelAttribute("domicilio") Domicilio domicilio,
                             Model model, RedirectAttributes flash){ // Redirección por lo tanto necesita un flash
        System.out.println(domicilio);
        flash.addFlashAttribute("success","Domicilio se guardo con éxito");
        domicilioService.guardar(domicilio);
        return "redirect:/inicio";
    }
    @GetMapping("lista-domicilio")
    public String listaDomicilio(@RequestParam(name="page",defaultValue = "0")int page,
                            Model model){
        Pageable pagReq= PageRequest.of(page,2);
        Page<Domicilio> domicilioEntities = domicilioService.buscarDomicilio(pagReq);
        RenderPagina<Domicilio> render = new RenderPagina<>("lista-domicilio",domicilioEntities);
        model.addAttribute("domicilio",domicilioEntities);
        model.addAttribute("page",render);
        model.addAttribute("contenido","Lista de los domicilios");
        return "domicilio/lista-domicilio";
    }

    @GetMapping("modificar-domicilio/{id}")
    public String domicilioModificar(@PathVariable("id") Integer id,Model model){
        Domicilio domicilio = domicilioService.buscarDomicilioId(id);
        model.addAttribute("domicilio",domicilio);
        model.addAttribute("contenido","Modificar domicilio");
        return "domicilio/alta-domicilio";
    }
    @GetMapping("eliminar-domicilio/{id}")
    public String eliminarDomicilio(@PathVariable("id") Integer id,RedirectAttributes flash){
        domicilioService.borrar(id);
        flash.addFlashAttribute("success","Se borró con éxito domicilio");
        return "redirect:/domicilio/lista-domicilio";
    }
}
