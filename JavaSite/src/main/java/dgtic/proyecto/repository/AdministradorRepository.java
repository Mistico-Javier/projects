package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
    @Query("SELECT a FROM administrador a WHERE a.correo LIKE %?1%")
    public List<Administrador> findByCorreo(String dato);
}
