package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "rol")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDrol")
    private int id;

    @Column(name = "nombre_Rol")
    private String nombreRol;

    /*
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;
     */
}
