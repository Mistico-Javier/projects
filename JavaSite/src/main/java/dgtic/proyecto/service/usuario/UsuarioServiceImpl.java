package dgtic.proyecto.service.usuario;

import dgtic.proyecto.dto.RolDTO;
import dgtic.proyecto.dto.UsuarioDTO;
import dgtic.proyecto.exception.UsuarioNotFoundException;
import dgtic.proyecto.model.entities.*;
import dgtic.proyecto.repository.UsuarioRepository;
import dgtic.proyecto.service.rol.RolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> buscarUsuario(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioId(Integer id) {
        Optional<Usuario> op = usuarioRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuarioNombre(String patron) {
        return usuarioRepository.findByNombre(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuarioApellidoPaterno(String patron) {
        return usuarioRepository.findByApellidoPaterno(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuarioApellidoMaterno(String patron) {
        return usuarioRepository.findByApellidoMaterno(patron);
    }

    /*@Override
    public List<Usuario> buscarUsuarioCorreo(String patron) {
        return usuarioRepository.findByCorreo(patron);
    }*/

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarEntreFechas(Date fechaInicio, Date fechaFin) {
        return usuarioRepository.findByFechaCreacionBetween(fechaInicio,fechaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public long cuentaUsuarioPorRol(Integer id) {
        return usuarioRepository.countUsuariosByRol(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findByCorreo(String email) throws UsuarioNotFoundException {
        Usuario object = usuarioRepository.findByCorreo(email);
        if (object == null){
            throw new UsuarioNotFoundException(email);
        }
        return convertEntityToDTO(object);
    }

    @Override
    public UsuarioDTO save(UsuarioDTO userAdmin) throws UsuarioNotFoundException {
        log.info("Service - UserAdmin.save");
        log.info("Service - UserAdmin.save object {} ", userAdmin);
        if (existsByCorreo(userAdmin.getCorreo()))
            throw new UsuarioNotFoundException(userAdmin.getCorreo());
        userAdmin.setPassword(passwordEncoder.encode(userAdmin.getPassword()));
        Usuario finalStatus = convertDTOtoEntity(userAdmin);
        finalStatus = usuarioRepository.save(finalStatus);
        return convertEntityToDTO(finalStatus);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorCorreo(String email) throws UsuarioNotFoundException{
        Usuario object = usuarioRepository.findByCorreo(email);
        if (object == null){
            throw new UsuarioNotFoundException(email);
        }
        return object;
    }

    @Override
    @Transactional(readOnly = true)
    public Domicilio buscarDomicilioPorUsuarioId(int id) {
        return usuarioRepository.findDomicilioByUsuarioId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MetodoPago buscarMetodoPagoPorUsuarioId(int id) {
        return usuarioRepository.findMetodoPagoByUsuarioId(id);
    }

    @Modifying
    @Override
    @Transactional
    public void actualizarDomicilio(int usuarioId, String calle, String numero, String coloniaBarrio, int codigoPostal, String alcaldiaMunicipio, String estado) {
        usuarioRepository.updateDomicilio(usuarioId, calle, numero, coloniaBarrio, codigoPostal, alcaldiaMunicipio, estado);
    }

    @Override
    public void guardarUsuarioMetodoPagoRelacionPorUsuarioId(UsuarioMetodoPagoRelacion usuarioMetodoPagoRelacion) {

    }

    private boolean existsByCorreo(String email){
        return usuarioRepository.existsByCorreo(email);
    }

    private UsuarioDTO convertEntityToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido_Paterno(usuario.getApellido_Paterno());
        dto.setApellido_Materno(usuario.getApellido_Materno());
        dto.setCorreo(usuario.getCorreo());
        dto.setPassword(usuario.getCorreo());
        dto.setUseIdStatus(usuario.getUseIdStatus());
        dto.setFecha_Creacion(usuario.getFecha_Creacion());
        Set<RolDTO> roles = new HashSet<>();
        for (Rol role : usuario.getUseRoles()){
            roles.add(rolService.convertEntityToDTO(role));
        }
        dto.setUseRoles(roles);
        return dto;
    }

    private Usuario convertDTOtoEntity(UsuarioDTO usuario) {
        Usuario entity = new Usuario();
        entity.setId(usuario.getId());
        entity.setNombre(usuario.getNombre());
        entity.setApellido_Paterno(usuario.getApellido_Paterno());
        entity.setApellido_Materno(usuario.getApellido_Materno());
        entity.setCorreo(usuario.getCorreo());
        entity.setPassword(usuario.getPassword());
        entity.setUseIdStatus(usuario.getUseIdStatus());
        entity.setFecha_Creacion(usuario.getFecha_Creacion());
        Set<Rol> roles = new HashSet<>();
        for (RolDTO role : usuario.getUseRoles()) {
            roles.add(rolService.convertDTOtoEntity(role));
        }
        entity.setUseRoles(roles);
        return entity;
    }
}
