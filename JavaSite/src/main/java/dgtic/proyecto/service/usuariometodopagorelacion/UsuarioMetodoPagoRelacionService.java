package dgtic.proyecto.service.usuariometodopagorelacion;

import dgtic.proyecto.model.entities.UsuarioMetodoPagoRelacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioMetodoPagoRelacionService {

    Page<UsuarioMetodoPagoRelacion> buscarUsuarioMetodoPagoRelacion(Pageable pageable);
    List<UsuarioMetodoPagoRelacion> buscarUsuarioMetodoPagoRelacion();
    void guardar(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion);
    void borrar(int id);
    UsuarioMetodoPagoRelacion buscarUsuarioMetodoPagoRelacionId(Integer id);
    List<UsuarioMetodoPagoRelacion> buscarUsuarioMetodoPagoRelacionesPorUsuarioId(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion);
    UsuarioMetodoPagoRelacion buscarUsuarioMetodoPagoRelacionPorUsuarioId(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion);
}
