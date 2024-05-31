package dgtic.proyecto.service.usuariometodopagorelacion;

import dgtic.proyecto.model.entities.UsuarioMetodoPagoRelacion;
import dgtic.proyecto.repository.UsuarioMetodoPagoRelacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioMetodoPagoRelacionImpl implements UsuarioMetodoPagoRelacionService {
    @Autowired
    UsuarioMetodoPagoRelacionRepository usuarioMetodoPagoRelacionRepository;
    @Override
    @Transactional(readOnly = true)
    public Page<UsuarioMetodoPagoRelacion> buscarUsuarioMetodoPagoRelacion(Pageable pageable) {
        return usuarioMetodoPagoRelacionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioMetodoPagoRelacion> buscarUsuarioMetodoPagoRelacion() {
        return usuarioMetodoPagoRelacionRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion) {
        usuarioMetodoPagoRelacionRepository.save(usuarioMetodoPagoRelacion);
    }

    @Override
    @Transactional
    public void borrar(int id) {
        usuarioMetodoPagoRelacionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioMetodoPagoRelacion buscarUsuarioMetodoPagoRelacionId(Integer id) {
        Optional<UsuarioMetodoPagoRelacion> op = usuarioMetodoPagoRelacionRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioMetodoPagoRelacion> buscarUsuarioMetodoPagoRelacionesPorUsuarioId(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion) {
        return usuarioMetodoPagoRelacionRepository.findUsuarioMetodoPagoRelacionesByUsuarioId(usuarioMetodoPagoRelacion.getUsuario().getId());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioMetodoPagoRelacion buscarUsuarioMetodoPagoRelacionPorUsuarioId(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion) {
        return usuarioMetodoPagoRelacionRepository.findUsuarioMetodoPagoRelacionByUsuarioId(usuarioMetodoPagoRelacion.getUsuario().getId());
    }
}
