package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Rol;
import dgtic.proyecto.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    @Query("SELECT r FROM rol r WHERE r.nombreRol = :nombreRol")
    Rol findByNombreRol(@Param("nombreRol") String nombreRol);

    @Query("SELECT ur.usuario FROM rol_usuario_relacion ur WHERE ur.rol.id = :idRol")
    List<Usuario> findAllUsuariosByRol(@Param("idRol") int idRol);

    @Query("SELECT COUNT(ur.usuario) FROM rol_usuario_relacion ur WHERE ur.rol.id = :idRol")
    Long countUsuariosByRol(@Param("idRol") int idRol);

    @Query("SELECT ur.rol FROM rol_usuario_relacion ur WHERE ur.usuario.id = :idUsuario")
    List<Rol> findAllRolesByUsuario(@Param("idUsuario") int idUsuario);
}
