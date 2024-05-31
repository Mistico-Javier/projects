package dgtic.proyecto.repository;

import dgtic.proyecto.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT c FROM cliente c WHERE c.nombre like %?1%")
    public List<Cliente> findByNombre(String dato);

    @Query("SELECT c FROM cliente c WHERE c.apellido_Paterno like %?1%")
    public List<Cliente> findByApellidoPaterno(String dato);

    @Query("SELECT c FROM cliente c WHERE c.apellido_Materno like %?1%")
    public List<Cliente> findByApellidoMaterno(String dato);

    @Query("SELECT c FROM cliente c WHERE c.correo_Electronico like %?1%")
    public List<Cliente> findByCorreoElectronico(String dato);
}
