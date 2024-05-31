package dgtic.proyecto.service.cliente;

import dgtic.proyecto.model.entities.Cliente;
import dgtic.proyecto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> buscarCliente(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarCliente(Integer id) {
        return clienteRepository.findAllById(Collections.singleton(id));
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarClienteId(Integer id) {
        Optional<Cliente> op = clienteRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarClienteNombre(String patron) {
        return clienteRepository.findByNombre(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarClienteApellidoPaterno(String patron) {
        return clienteRepository.findByApellidoPaterno(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarClienteApellidoMaterno(String patron) {
        return clienteRepository.findByApellidoMaterno(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarClienteCorreoElectronico(String patron) {
        return clienteRepository.findByCorreoElectronico(patron);
    }


}
