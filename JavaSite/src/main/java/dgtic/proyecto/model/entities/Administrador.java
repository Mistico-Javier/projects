package dgtic.proyecto.model.entities;

import dgtic.proyecto.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "administrador")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDadministrador")
    private Integer id;

    @Column(name = "correo")
    @NoEspacioNoVacio
    private String correo;

    @NoEspacioNoVacio
    @Column(name = "password")
    private String password;
}
