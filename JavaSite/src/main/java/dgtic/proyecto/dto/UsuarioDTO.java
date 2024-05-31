package dgtic.proyecto.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private int id;
    private String nombre;
    private String apellido_Paterno;
    private String apellido_Materno;
    private String correo;
    private String password;
    private LocalDateTime fecha_Creacion;
    private Integer useIdStatus;
    private Set<RolDTO> useRoles = new HashSet<>();
}
