package dgtic.proyecto.service.carrito;

import dgtic.proyecto.model.entities.Carrito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarritoService {
    Page<Carrito> buscarCarrito(Pageable pageable);
    List<Carrito> buscarCarrito();
    void guardar(Carrito carrito);
    void borrar(Integer id);
    Carrito buscarCarritoId(Integer id);
    Carrito buscarCarritoPorUsuarioId(int id);
    List<Carrito> buscarCarritosPorUsuarioId(int id);
    List<Carrito> buscarCarritoPorProductoId(int id);
    List<Carrito> buscarCarritosPorUsuarioYProducto(int idUsuario,int idProducto);
    Carrito buscarCarritoPorUsuarioYProducto(int idUsuario,int idProducto);
    List<Carrito> buscarCarritoPorUsuarioYCantidadMayorQue(int idUsuario, int cantidad);
    List<Carrito> buscarCarritoPorUsuarioYPrecioMayorQue(int idUsuario, double precio);
    void borrarCarritoPorUsuarioId(int id);
}
