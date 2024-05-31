package dgtic.proyecto.service.administrador;

import dgtic.proyecto.model.entities.Administrador;
import dgtic.proyecto.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServiceImpl implements AdministradorService{
    @Autowired
    AdministradorRepository administradorRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Administrador> buscarAdministrador(Pageable pageable) {
        return administradorRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Administrador> buscarAdministrador() {
        return administradorRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Administrador administrador) {
        administradorRepository.save(administrador);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        administradorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Administrador buscarAdministradorId(Integer id) {
        Optional<Administrador> op = administradorRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Administrador> buscarPorCorreo(String patron) {
        return administradorRepository.findByCorreo(patron);
    }
}
