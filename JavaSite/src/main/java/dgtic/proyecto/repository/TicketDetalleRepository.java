package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.TicketDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketDetalleRepository extends JpaRepository<TicketDetalle, Integer> {
    // Devuelve todos los detalles del ticket para un ID de ticket específico.
    @Query("SELECT td FROM ticket_detalle td WHERE td.ticket.id = :ticketId")
    List<TicketDetalle> findByTicketId(@Param("ticketId") int ticketId);

    // Devuelve todos los detalles del ticket para un ID de producto específico.
    @Query("SELECT td FROM ticket_detalle td WHERE td.producto.id = :productoId")
    List<TicketDetalle> findByProductoId(@Param("productoId") int productoId);

    // Devuelve todos los detalles del ticket para un ID de usuario específico.
    @Query("SELECT td FROM ticket_detalle td WHERE td.ticket.usuario.id = :usuarioId")
    List<TicketDetalle> findByUsuarioId(@Param("usuarioId") int usuarioId);

    // Devuelve todos los detalles del ticket donde el monto total (precio * cantidad) es mayor que un monto específico.
    @Query("SELECT td FROM ticket_detalle td WHERE td.precio * td.cantidad > :amount")
    List<TicketDetalle> findByTotalAmountGreaterThan(@Param("amount") double amount);

    // Devuelve todos los detalles del ticket dentro de un rango de fechas específico.
    @Query("SELECT td FROM ticket_detalle td WHERE td.ticket.fecha_Compra BETWEEN :startDate AND :endDate")
    List<TicketDetalle> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
