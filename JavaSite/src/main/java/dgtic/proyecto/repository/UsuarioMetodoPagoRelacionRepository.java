package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.UsuarioMetodoPagoRelacion;
import dgtic.proyecto.service.usuariometodopagorelacion.UsuarioMetodoPagoRelacionService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioMetodoPagoRelacionRepository extends JpaRepository<UsuarioMetodoPagoRelacion, Integer> {

    @Query("SELECT r FROM usuario_metodo_pago_relacion r WHERE r.usuario.id = :idUsuario")
    List<UsuarioMetodoPagoRelacion> findUsuarioMetodoPagoRelacionesByUsuarioId(@Param("idUsuario") int idUsuario);

    @Query("SELECT r FROM usuario_metodo_pago_relacion r WHERE r.usuario.id = :idUsuario")
    UsuarioMetodoPagoRelacion findUsuarioMetodoPagoRelacionByUsuarioId(@Param("idUsuario") int idUsuario);

    /*@Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario_metodo_pago_relacion (IDusuario, IDmetodo_Pago) VALUES (:userId, :metodoPagoId)", nativeQuery = true)
    void saveMetodoPago(@Param("userId") int userId, @Param("metodoPagoId") int metodoPagoId);*/
}
