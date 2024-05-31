package dgtic.proyecto.service.metodopago;

import dgtic.proyecto.model.entities.MetodoPago;
import dgtic.proyecto.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService{
    @Autowired
    MetodoPagoRepository metodoPagoRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<MetodoPago> buscarMetodoPago(Pageable pageable) {
        return metodoPagoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MetodoPago> buscarMetodoPago() {
        return metodoPagoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(MetodoPago metodoPago) {
        metodoPagoRepository.save(metodoPago);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        metodoPagoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MetodoPago buscarMetodoPagoId(Integer id) {
        Optional<MetodoPago> op = metodoPagoRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MetodoPago> buscarMetodoPagoPorCorreoUsuario(String correoUsuario) {
        return metodoPagoRepository.findMetodosPagoByCorreoUsuario(correoUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public long contarMetodoPago() {
        return metodoPagoRepository.countMetodosPago();
    }
}
