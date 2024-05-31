package dgtic.proyecto.security.model;

import dgtic.proyecto.model.entities.Rol;
import dgtic.proyecto.model.entities.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private int id;
    private String name;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;
    private Usuario usuario;

    public UserDetailsImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    public UserDetailsImpl(int id,String name, String email, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getUseRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getNombreRol())
        ).collect(Collectors.toList());
        return new UserDetailsImpl(
                usuario.getId(),
                usuario.getCorreo(),//getFullName
                usuario.getCorreo(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null == usuario.getUseRoles()) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Rol role : usuario.getUseRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNombreRol()));
        }
        return grantedAuthorities;
    }

    /**
     * getUsername
     * @return username
     */
    @Override
    public String getUsername() {
        return usuario.getCorreo();
    } //getNombre()

    /**
     * getPassword (OTP)
     * @return password
     */
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    /**
     * getName
     * @return name
     */
    public String getName() {
        return usuario.getCorreo();
    } //getNombre()

    /**
     * getEmail
     * @return email
     */
    public String getEmail() {
        return usuario.getCorreo();
    }

    /*
     * isEnabled
     * @return if user is enabled
    */
    @Override
    public boolean isEnabled() {
        return usuario.getUseIdStatus() == 1;
    }

    /**
     * isAccountNonLocked
     * @return if user is locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * isAccountNonExpired
     * @return if account is not expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * isCredentialsNonExpired
     * @return if credential is not expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
