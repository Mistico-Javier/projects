package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "rol_usuario_relacion")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RolUsuarioRelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDrol_usuario_relacion")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IDusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "IDrol")
    private Rol rol;
}
