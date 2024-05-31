package dgtic.proyecto.service.metodopago;

import dgtic.proyecto.model.entities.MetodoPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MetodoPagoService {
    Page<MetodoPago> buscarMetodoPago(Pageable pageable);
    List<MetodoPago> buscarMetodoPago();
    void guardar(MetodoPago metodoPago);
    void borrar(Integer id);
    MetodoPago buscarMetodoPagoId(Integer id);
    List<MetodoPago> buscarMetodoPagoPorCorreoUsuario(String correoUsuario);
    long contarMetodoPago();
}
