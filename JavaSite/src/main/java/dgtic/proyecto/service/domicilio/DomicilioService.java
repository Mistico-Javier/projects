package dgtic.proyecto.service.domicilio;

import dgtic.proyecto.model.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService {
    Page<Domicilio> buscarDomicilio(Pageable pageable);
    List<Domicilio> buscarDomicilio();
    void guardar(Domicilio domicilio);
    void borrar(Integer id);
    Domicilio buscarDomicilioId(Integer id);
    List<Domicilio> buscarDomicilioCalle(String patron);
    List<Domicilio> buscarDomicilioColoniaBarrio(String patron);
    List<Domicilio> buscarDomicilioAlcaldiaMunicipio(String patron);
    Domicilio buscarDomicilioPorCorreo(String correo);
    Domicilio buscarDomicilioPorUsuarioId(int id);

    void actualizarDomicilio(Domicilio domicilio);
}
