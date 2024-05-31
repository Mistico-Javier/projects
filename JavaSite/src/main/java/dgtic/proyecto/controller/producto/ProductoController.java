package dgtic.proyecto.controller.producto;

import dgtic.proyecto.model.entities.Producto;
import dgtic.proyecto.service.producto.ProductoService;
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
@RequestMapping(value = "producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("alta-producto")
    public String altaProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("contenido","Alta de un Producto");
        model.addAttribute("producto",producto);
        return "producto/alta-producto";
    }
    @PostMapping("salvar-producto")
    public String salvarProducto(@Valid @ModelAttribute("producto") Producto producto,
                             Model model, RedirectAttributes flash){ // Redirección por lo tanto necesita un flash
        System.out.println(producto);
        flash.addFlashAttribute("success","Producto se guardo con éxito");
        productoService.guardar(producto);
        return "redirect:/inicio";
    }
    @GetMapping("lista-producto")
    public String listaProducto(@RequestParam(name="page",defaultValue = "0")int page,
                            Model model){
        Pageable pagReq= PageRequest.of(page,4);
        Page<Producto> productoEntities = productoService.buscarProducto(pagReq);
        RenderPagina<Producto> render = new RenderPagina<>("lista-producto",productoEntities);
        model.addAttribute("producto",productoEntities);
        model.addAttribute("page",render);
        model.addAttribute("contenido","Lista de los Productos");
        return "producto/lista-producto";
    }

    @GetMapping("modificar-producto/{id}")
    public String productoModificar(@PathVariable("id") Integer id,Model model){
        Producto producto = productoService.buscarProductoId(id);
        model.addAttribute("producto",producto);
        model.addAttribute("contenido","Modificar producto");
        return "producto/alta-producto";
    }
    @GetMapping("eliminar-producto/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id,RedirectAttributes flash){
        productoService.borrar(id);
        flash.addFlashAttribute("success","Se borró con éxito producto");
        return "redirect:/producto/lista-producto";
    }

    @GetMapping("resultados-busqueda")
    public String buscarProducto(@RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="query") String nombre,
                                Model model){
        Pageable pagReq= PageRequest.of(page,25);
        Page<Producto> productoEntities = productoService.buscarProductoPorNombre(nombre, pagReq);
        RenderPagina<Producto> render = new RenderPagina<>("resultados-busqueda",productoEntities,nombre);
        model.addAttribute("producto",productoEntities);
        model.addAttribute("page",render);
        model.addAttribute("contenido","Resultados de la búsqueda");
        return "producto/resultados-busqueda";
    }
}
