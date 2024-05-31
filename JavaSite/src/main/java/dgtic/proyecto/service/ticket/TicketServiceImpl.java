package dgtic.proyecto.service.ticket;

import dgtic.proyecto.model.entities.Ticket;
import dgtic.proyecto.model.entities.TicketDetalle;
import dgtic.proyecto.repository.TicketRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Ticket> buscarTicket(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> buscarTicket() {
        return ticketRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        ticketRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket buscarTicketId(Integer id) {
        Optional<Ticket> op = ticketRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> buscarTicketUsuarioId(int id) {
        return ticketRepository.findAllByUsuarioId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> buscarTicketFechaCompra(Date fecha) {
        return ticketRepository.findAllByFechaCompra(fecha);
    }
}
