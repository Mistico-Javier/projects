package dgtic.proyecto.service.tarjeta;

import dgtic.proyecto.model.entities.Tarjeta;
import dgtic.proyecto.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServiceImpl implements TarjetaService{
    @Autowired
    TarjetaRepository tarjetaRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Tarjeta> buscarTarjeta(Pageable pageable) {
        return tarjetaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarjeta> buscarTarjeta() {
        return tarjetaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Tarjeta tarjeta) {
        tarjetaRepository.save(tarjeta);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        tarjetaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Tarjeta buscarTarjetaId(Integer id) {
        Optional<Tarjeta> op = tarjetaRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarjeta> buscarTarjetaPorNombre(String nombre) {
        return tarjetaRepository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarjeta> buscarTarjetaPorCliente(int id) {
        return tarjetaRepository.findTarjetasByCliente(id);
    }

    @Override
    public List<Tarjeta> buscarTarjetaPorTipoTarjeta(String tipoTarjeta) {
        return tarjetaRepository.findAllByTipoTarjeta(tipoTarjeta);
    }
}
