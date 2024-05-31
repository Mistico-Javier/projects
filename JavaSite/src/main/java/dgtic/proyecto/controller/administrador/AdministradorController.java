package dgtic.proyecto.controller.administrador;

import dgtic.proyecto.model.entities.Administrador;
import dgtic.proyecto.service.administrador.AdministradorService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "administrador")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @GetMapping("alta-administrador")
    public String altaAdministrador(Model model){
        Administrador administrador = new Administrador();
        model.addAttribute("contenido","Alta de un Administrador");
        model.addAttribute("administrador",administrador);
        return "administrador/alta-administrador";
    }

    @PostMapping("salvar-administrador")
    public String salvarAdministrador(@Valid @ModelAttribute("administrador") Administrador administrador,
                                      BindingResult result,
                                      RedirectAttributes model){
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en la entrada de datos");
            return "administrador/alta-administrador";
        }
        administradorService.guardar(administrador);
        model.addFlashAttribute("success","Administrador se almacenó con éxito");
        return "redirect:/inicio";
    }
    /*@PostMapping("salvar-administrador")
    public String salvarAdministrador(@Valid @ModelAttribute("administrador") Administrador administrador,
                             Model model, RedirectAttributes flash){ // Redirección por lo tanto necesita un flash
        System.out.println(administrador);
        flash.addFlashAttribute("success","Administrador se guardo con éxito");
        administradorService.guardar(administrador);
        return "redirect:/inicio";
    }*/

    @GetMapping("lista-administrador")
    public String listaAdministrador(@RequestParam(name="page",defaultValue = "0")int page,
                            Model model){
        Pageable pagReq= PageRequest.of(page,2);
        Page<Administrador> administradorEntities = administradorService.buscarAdministrador(pagReq);
        RenderPagina<Administrador> render = new RenderPagina<>("lista-administrador",administradorEntities);
        model.addAttribute("administrador",administradorEntities);
        model.addAttribute("page",render);
        model.addAttribute("contenido","Lista de los Administradores");
        return "administrador/lista-administrador";
    }

    @GetMapping("modificar-administrador/{id}")
    public String administradorModificar(@PathVariable("id") Integer id,Model model){
        Administrador administrador = administradorService.buscarAdministradorId(id);
        model.addAttribute("administrador",administrador);
        model.addAttribute("contenido","Modificar Administrador");
        return "administrador/alta-administrador";
    }
    @GetMapping("eliminar-administrador/{id}")
    public String eliminarAdministrador(@PathVariable("id") Integer id,RedirectAttributes flash){
        administradorService.borrar(id);
        flash.addFlashAttribute("success","Se borró con éxito Administrador");
        return "redirect:/administrador/lista-administrador";
    }
}
