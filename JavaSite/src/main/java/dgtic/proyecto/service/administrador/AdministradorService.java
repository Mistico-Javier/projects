package dgtic.proyecto.service.administrador;

import dgtic.proyecto.model.entities.Administrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdministradorService {
    Page<Administrador> buscarAdministrador(Pageable pageable);
    List<Administrador> buscarAdministrador();
    void guardar(Administrador administrador);
    void borrar(Integer id);
    Administrador buscarAdministradorId(Integer id);
    List<Administrador> buscarPorCorreo(String patron);
}
