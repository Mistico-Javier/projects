package dgtic.proyecto.service.rol;

import dgtic.proyecto.dto.RolDTO;
import dgtic.proyecto.model.entities.Rol;
import dgtic.proyecto.model.entities.Usuario;
import dgtic.proyecto.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{
    @Autowired
    RolRepository rolRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Rol> buscarRol(Pageable pageable) {
        return rolRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> buscarRol() {
        return rolRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        rolRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol buscarRolId(Integer id) {
        Optional<Rol> op = rolRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol buscarRolNombre(String nombreRol) {
        return rolRepository.findByNombreRol(nombreRol);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuariosPorRol(int idRol) {
        return rolRepository.findAllUsuariosByRol(idRol);
    }

    @Override
    @Transactional(readOnly = true)
    public long cuentaUsuariosPorRol(int idRol) {
        return rolRepository.countUsuariosByRol(idRol);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> buscarRolesPorUsuario(int idUsuario) {
        return rolRepository.findAllRolesByUsuario(idUsuario);
    }

    @Override
    public RolDTO convertEntityToDTO(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombreRol(rol.getNombreRol());
        return dto;
    }

    @Override
    public Rol convertDTOtoEntity(RolDTO rol) {
        Rol entity = new Rol();
        entity.setId(rol.getId());
        entity.setNombreRol(rol.getNombreRol());
        return entity;
    }
}
