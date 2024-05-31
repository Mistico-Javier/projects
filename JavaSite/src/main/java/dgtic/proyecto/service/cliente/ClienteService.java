package dgtic.proyecto.service.cliente;

import dgtic.proyecto.model.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
    Page<Cliente> buscarCliente(Pageable pageable);
    List<Cliente> buscarCliente();
    List<Cliente> buscarCliente(Integer id);
    void guardar(Cliente cliente);
    void borrar(Integer id);
    Cliente buscarClienteId(Integer id);
    List<Cliente> buscarClienteNombre(String patron);
    List<Cliente> buscarClienteApellidoPaterno(String patron);
    List<Cliente> buscarClienteApellidoMaterno(String patron);
    List<Cliente> buscarClienteCorreoElectronico(String patron);
}
