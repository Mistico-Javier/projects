package dgtic.proyecto.service.ticketdetalle;

import dgtic.proyecto.model.entities.TicketDetalle;
import dgtic.proyecto.repository.TicketDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketDetalleImpl implements TicketDetalleService{
    @Autowired
    TicketDetalleRepository ticketDetalleRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<TicketDetalle> buscarTicketDetalle(Pageable pageable) {
        return ticketDetalleRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDetalle> buscarTicketDetalle() {
        return ticketDetalleRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(TicketDetalle ticketDetalle) {
        ticketDetalleRepository.save(ticketDetalle);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        ticketDetalleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TicketDetalle buscarTicketDetalleId(Integer id) {
        Optional<TicketDetalle> op = ticketDetalleRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDetalle> buscarTicketDetallePorTicketId(int id) {
        return ticketDetalleRepository.findByTicketId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDetalle> buscarTicketDetallePorProductoId(int id) {
        return ticketDetalleRepository.findByProductoId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDetalle> buscarTicketDetallePorUsuarioId(int id) {
        return ticketDetalleRepository.findByUsuarioId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDetalle> buscarTicketDetallePorCantidadMayorQue(double cantidad) {
        return ticketDetalleRepository.findByTotalAmountGreaterThan(cantidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDetalle> buscarTicketDetallePorFechaEntre(String fechaInicial, String fechaFinal) {
        return ticketDetalleRepository.findByDateRange(fechaInicial, fechaFinal);
    }
}
