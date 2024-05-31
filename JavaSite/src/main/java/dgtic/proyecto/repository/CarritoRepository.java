package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
    // Devuelve todos los elementos de un carrito para un ID de usuario específico.
    @Query("SELECT c FROM carrito c WHERE c.usuario.id = :usuarioId")
    Carrito findCarritoByUsuarioId(@Param("usuarioId") int usuarioId);

    // Devuelve todos los elementos del carrito para un ID de usuario específico.
    @Query("SELECT c FROM carrito c WHERE c.usuario.id = :usuarioId")
    List<Carrito> findCarritosByUsuarioId(@Param("usuarioId") int usuarioId);

    // Devuelve todos los elementos del carrito para un ID de producto específico.
    @Query("SELECT c FROM carrito c WHERE c.producto.id = :productoId")
    List<Carrito> findByProductoId(@Param("productoId") int productoId);

    // Devuelve todos los elementos del carrito para un ID de usuario específico y un ID de producto específico.
    @Query("SELECT c FROM carrito c WHERE c.usuario.id = :usuarioId AND c.producto.id = :productoId")
    List<Carrito> findCarritosByUsuarioIdAndProductoId(@Param("usuarioId") int usuarioId, @Param("productoId") int productoId);

    // Devuelve el carrito para un ID de usuario específico y un ID de producto específico.
    @Query("SELECT c FROM carrito c WHERE c.usuario.id = :usuarioId AND c.producto.id = :productoId")
    Carrito findByUsuarioIdAndProductoId(@Param("usuarioId") int usuarioId, @Param("productoId") int productoId);

    // Devuelve todos los elementos del carrito para un ID de usuario específico donde la cantidad es mayor que un valor especificado.
    @Query("SELECT c FROM carrito c WHERE c.usuario.id = :usuarioId AND c.cantidad > :cantidad")
    List<Carrito> findByUsuarioIdAndCantidadGreaterThan(@Param("usuarioId") int usuarioId, @Param("cantidad") int cantidad);

    // Devuelve todos los elementos del carrito para un ID de usuario específico donde el precio del producto es mayor que un valor especificado.
    @Query("SELECT c FROM carrito c JOIN c.producto p WHERE c.usuario.id = :usuarioId AND p.precio > :precio")
    List<Carrito> findByUsuarioIdAndProductoPrecioGreaterThan(@Param("usuarioId") int usuarioId, @Param("precio") double precio);

    // Eliminar un carrito de un usuario específico
    @Modifying
    @Transactional
    @Query("DELETE FROM carrito c WHERE c.usuario.id = :usuarioId")
    void deleteCarritoByUsuarioId(@Param("usuarioId") int usuarioId);

}
