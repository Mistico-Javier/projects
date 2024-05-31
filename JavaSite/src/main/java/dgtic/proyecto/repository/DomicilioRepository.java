package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {
    @Query("SELECT d FROM domicilio d WHERE d.calle LIKE %?1%")
    public List<Domicilio> findByCalle(String dato);

    @Query("SELECT d FROM domicilio d WHERE d.coloniaBarrio LIKE %?1%")
    public List<Domicilio> findByColoniaBarrio(String dato);

    @Query("SELECT d FROM domicilio d WHERE d.alcaldiaMunicipio LIKE %?1%")
    public List<Domicilio> findByAlcaldiaMunicipio(String dato);

    // Encuentra el domicilio de un usuario por su correo electrónico
    @Query("SELECT d FROM domicilio d WHERE d.usuario.correo = :correoUsuario")
    Domicilio findByUsuarioCorreo(@Param("correoUsuario") String correoUsuario);

    // Encuentra el domicilio de un usuario por su correo electrónico
    @Query("SELECT d FROM domicilio d WHERE d.usuario.id = :idUsuario")
    Domicilio findByUsuarioId(@Param("idUsuario") int idUsuario);

    @Modifying
    @Transactional
    @Query("UPDATE domicilio d SET d.calle = :calle, d.numero = :numero, d.coloniaBarrio = :coloniaBarrio, d.codigoPostal = :codigoPostal, d.alcaldiaMunicipio = :alcaldiaMunicipio, d.estado = :estado WHERE d.usuario.id = :usuarioId")
    void updateDomicilioByUsuarioId(
            @Param("usuarioId") int usuarioId,
            @Param("calle") String calle,
            @Param("numero") String numero,
            @Param("coloniaBarrio") String coloniaBarrio,
            @Param("codigoPostal") int codigoPostal,
            @Param("alcaldiaMunicipio") String alcaldiaMunicipio,
            @Param("estado") String estado
    );
}
