package dgtic.proyecto.service.tarjeta;

import dgtic.proyecto.model.entities.Tarjeta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TarjetaService {
    Page<Tarjeta> buscarTarjeta(Pageable pageable);
    List<Tarjeta> buscarTarjeta();
    void guardar(Tarjeta tarjeta);
    void borrar(Integer id);
    Tarjeta buscarTarjetaId(Integer id);
    List<Tarjeta> buscarTarjetaPorNombre(String nombre);
    List<Tarjeta> buscarTarjetaPorCliente(int id);
    List<Tarjeta> buscarTarjetaPorTipoTarjeta(String tipoTarjeta);
}
