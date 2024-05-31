package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
    // Encuentra todos los métodos de pago asociados a un usuario por su correo.
    @Query(value = "SELECT mp.metodoPago " +
            "FROM metodo_Pago mp " +
            "JOIN usuario_metodo_pago_relacion umpr ON mp.id = umpr.usuario.id " + //IDmetodo_Pago
            "JOIN usuario u ON umpr.usuario.id = u.id " + // IDusuario
            "WHERE u.correo = :correoUsuario")
    List<MetodoPago> findMetodosPagoByCorreoUsuario(@Param("correoUsuario") String correoUsuario);

    // Cuenta el número total de métodos de pago registrados en el sistema.
    @Query("SELECT COUNT(m) FROM metodo_Pago m")
    Long countMetodosPago();
}