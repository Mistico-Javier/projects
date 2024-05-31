package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT c FROM producto c WHERE c.nombre LIKE %?1%")
    public Page<Producto> findByNombreProducto(String dato, Pageable pageable);
    /*@Query("SELECT c FROM producto c WHERE c.nombre LIKE %?1%")
    public List<Producto> findByNombreProducto(String dato);*/

    @Query("SELECT c FROM producto c WHERE c.marca LIKE %?1%")
    public List<Producto> findByMarcaProducto(String dato);

    // Selecciona todos los productos que pertenecen a una marca específica
    @Query("SELECT cp FROM producto cp WHERE cp.marca = :marca")
    List<Producto> findByMarca(@Param("marca") String marca);

    // Selecciona todos los productos cuyo precio es menor que un valor específico, proporcionado como parámetro
    @Query("SELECT cp FROM producto cp WHERE cp.precio < :precio")
    List<Producto> findByPrecioMenorQue(@Param("precio") Double precio);

    // Selecciona todos los productos cuyo precio es mayor que un valor específico, proporcionado como parámetro
    @Query("SELECT cp FROM producto cp WHERE cp.precio > :precio")
    List<Producto> findByPrecioMayorQue(@Param("precio") Double precio);

    // Permite buscar todos los productos en el catálogo cuyo precio se encuentra dentro de un rango específico
    @Query("SELECT cp FROM producto cp WHERE cp.precio BETWEEN :precioMin AND :precioMax")
    List<Producto> findByPrecioBetween(@Param("precioMin") Double precioMin, @Param("precioMax") Double precioMax);
}
