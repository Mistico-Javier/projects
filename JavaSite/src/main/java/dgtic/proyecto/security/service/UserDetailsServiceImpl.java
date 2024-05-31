package dgtic.proyecto.security.service;

import dgtic.proyecto.model.entities.Usuario;
import dgtic.proyecto.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Security - UserDetailsServiceImpl.loadUserByUsername {}", username);
        Usuario userInfo = Optional.ofNullable(usuarioRepository.findByCorreo(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found in database"));
        String userName = userInfo.getNombre(); //getCorreo o getNombre
        String password = userInfo.getPassword();
        List<GrantedAuthority> authorities = userInfo.getUseRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getNombreRol())).collect(Collectors.toList());
        return new User(userName, password, authorities);
    }
}
