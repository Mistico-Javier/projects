package dgtic.proyecto.service.rol;

import dgtic.proyecto.dto.RolDTO;
import dgtic.proyecto.model.entities.Rol;
import dgtic.proyecto.model.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RolService {
    Page<Rol> buscarRol(Pageable pageable);
    List<Rol> buscarRol();
    void guardar(Rol rol);
    void borrar(Integer id);
    Rol buscarRolId(Integer id);
    Rol buscarRolNombre(String nombreRol);
    List<Usuario> buscarUsuariosPorRol(int idRol);
    long cuentaUsuariosPorRol(int idRol);
    List<Rol> buscarRolesPorUsuario(int idUsuario);

    RolDTO convertEntityToDTO(Rol rol);
    Rol convertDTOtoEntity(RolDTO rol);
}
