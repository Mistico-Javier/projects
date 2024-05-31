package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
    @Query("select c FROM tarjeta c where c.nombrePersonaTarjeta like %?1%")
    public List<Tarjeta> findByNombre(String dato);

    // Obtiene todas las tarjetas asociadas a un cliente específico mediante su id
    @Query("SELECT t FROM tarjeta t WHERE t.id = :clienteId")
    List<Tarjeta> findTarjetasByCliente(int clienteId);

    // Encuentra todas las tarjetas de un tipo específico
    @Query("SELECT t FROM tarjeta t WHERE t.tipoTarjeta = :tipoTarjeta")
    List<Tarjeta> findAllByTipoTarjeta(@Param("tipoTarjeta") String tipoTarjeta);
}
