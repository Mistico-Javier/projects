package dgtic.proyecto.service.producto;

import dgtic.proyecto.model.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    Page<Producto> buscarProducto(Pageable pageable);
    List<Producto> buscarProducto();
    void guardar(Producto producto);
    void borrar(Integer id);
    Producto buscarProductoId(Integer id);
    Page<Producto> buscarProductoPorNombre(String dato, Pageable pageable);
    //List<Producto> buscarProductoNombrePatron(String patron);
    List<Producto> buscarProductoMarcaPatron(String patron);
    List<Producto> buscarProductoMarca(String marca);
    List<Producto> buscarProductoMenorQue(Double precio);
    List<Producto> buscarProductoMayorQue(Double precio);
    List<Producto> buscarProductoEntre(Double precioMin, Double precioMax);
}
