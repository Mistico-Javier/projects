package dgtic.proyecto.service.ticketdetalle;

import dgtic.proyecto.model.entities.TicketDetalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketDetalleService {
    Page<TicketDetalle> buscarTicketDetalle(Pageable pageable);
    List<TicketDetalle> buscarTicketDetalle();
    void guardar(TicketDetalle ticketDetalle);
    void borrar(Integer id);
    TicketDetalle buscarTicketDetalleId(Integer id);
    List<TicketDetalle> buscarTicketDetallePorTicketId(int id);
    List<TicketDetalle> buscarTicketDetallePorProductoId(int id);
    List<TicketDetalle> buscarTicketDetallePorUsuarioId(int id);
    List<TicketDetalle> buscarTicketDetallePorCantidadMayorQue(double cantidad);
    List<TicketDetalle> buscarTicketDetallePorFechaEntre(String fechaInicial, String fechaFinal);
}
