package dgtic.proyecto.service.ticket;

import dgtic.proyecto.model.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface TicketService {
    Page<Ticket> buscarTicket(Pageable pageable);
    List<Ticket> buscarTicket();
    void guardar(Ticket ticket);
    void borrar(Integer id);
    Ticket buscarTicketId(Integer id);
    List<Ticket> buscarTicketUsuarioId(int id);
    List<Ticket> buscarTicketFechaCompra(Date fecha);
}
