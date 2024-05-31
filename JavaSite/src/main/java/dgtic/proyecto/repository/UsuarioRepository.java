package dgtic.proyecto.repository;

import dgtic.proyecto.dto.UsuarioDTO;
import dgtic.proyecto.model.entities.Domicilio;
import dgtic.proyecto.model.entities.MetodoPago;
import dgtic.proyecto.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT c FROM usuario c WHERE c.nombre like %?1%")
    public List<Usuario> findByNombre(String dato);

    @Query("SELECT c FROM usuario c WHERE c.apellido_Paterno like %?1%")
    public List<Usuario> findByApellidoPaterno(String dato);

    @Query("SELECT c FROM usuario c WHERE c.apellido_Materno like %?1%")
    public List<Usuario> findByApellidoMaterno(String dato);

    /*@Query("SELECT c FROM usuario c WHERE c.correo like %?1%")
    public List<Usuario> findByCorreo(String dato);*/

    @Query("SELECT u FROM usuario u WHERE u.fecha_Creacion BETWEEN :fechaInicio AND :fechaFin")
    List<Usuario> findByFechaCreacionBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT COUNT(ur) FROM rol_usuario_relacion ur WHERE ur.rol.id = :idRol")
    Long countUsuariosByRol(@Param("idRol") int idRol);

    Usuario findByCorreo(String email);
    boolean existsByCorreo(String email);

    // Encuentra el domicilio de un usuario por su id
    @Query("SELECT d FROM domicilio d WHERE d.usuario.id = :usuarioId")
    Domicilio findDomicilioByUsuarioId(@Param("usuarioId") Integer usuarioId);

    @Query("SELECT up.metodoPago FROM usuario_metodo_pago_relacion up WHERE up.usuario.id = :idUsuario")
    MetodoPago findMetodoPagoByUsuarioId(@Param("idUsuario") int idUsuario);

    @Modifying
    @Transactional
    @Query("UPDATE domicilio d SET d.calle = :calle, d.numero = :numero, d.coloniaBarrio = :coloniaBarrio, d.codigoPostal = :codigoPostal, d.alcaldiaMunicipio = :alcaldiaMunicipio, d.estado = :estado WHERE d.usuario.id = :usuarioId")
    void updateDomicilio(@Param("usuarioId") int usuarioId, @Param("calle") String calle, @Param("numero") String numero, @Param("coloniaBarrio") String coloniaBarrio, @Param("codigoPostal") int codigoPostal, @Param("alcaldiaMunicipio") String alcaldiaMunicipio, @Param("estado") String estado);


}
