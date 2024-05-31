package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Selecciona todos los tickets finales asociados a un usuario específico
    @Query("SELECT t FROM ticket t WHERE t.usuario.id = :usuarioId")
    List<Ticket> findAllByUsuarioId(@Param("usuarioId") int usuarioId);

    // Selecciona todos los tickets finales cuya fecha de compra coincida con la fecha especificada
    @Query("SELECT t FROM ticket t WHERE DATE(t.fecha_Compra) = :fecha")
    List<Ticket> findAllByFechaCompra(@Param("fecha") Date fecha);
}
