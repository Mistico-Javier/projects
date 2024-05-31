package dgtic.proyecto.service.usuario;

import dgtic.proyecto.dto.UsuarioDTO;
import dgtic.proyecto.exception.UsuarioNotFoundException;
import dgtic.proyecto.model.entities.Domicilio;
import dgtic.proyecto.model.entities.MetodoPago;
import dgtic.proyecto.model.entities.Usuario;
import dgtic.proyecto.model.entities.UsuarioMetodoPagoRelacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface UsuarioService {
    Page<Usuario> buscarUsuario(Pageable pageable);
    List<Usuario> buscarUsuario();
    void guardar(Usuario usuario);
    void borrar(Integer id);
    Usuario buscarUsuarioId(Integer id);
    List<Usuario> buscarUsuarioNombre(String patron);
    List<Usuario> buscarUsuarioApellidoPaterno(String patron);
    List<Usuario> buscarUsuarioApellidoMaterno(String patron);
    //List<Usuario> buscarUsuarioCorreo(String patron);
    List<Usuario> buscarEntreFechas(Date fechaInicio, Date fechaFin);
    long cuentaUsuarioPorRol(Integer id);

    UsuarioDTO findByCorreo(String email) throws UsuarioNotFoundException;
    UsuarioDTO save(UsuarioDTO usuarioDTO) throws UsuarioNotFoundException;

    Usuario buscarPorCorreo(String email)throws UsuarioNotFoundException;

    Domicilio buscarDomicilioPorUsuarioId(int id);

    MetodoPago buscarMetodoPagoPorUsuarioId(int id);

    void actualizarDomicilio(int usuarioId, String calle, String numero, String coloniaBarrio, int codigoPostal, String alcaldiaMunicipio, String estado);

    void guardarUsuarioMetodoPagoRelacionPorUsuarioId(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion);
}
