package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDdomicilio")
    private int id;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private String numero;

    @Column(name = "colonia_Barrio")
    private String coloniaBarrio;

    @Column(name = "codigo_Postal")
    private int codigoPostal;

    @Column(name = "alcaldia_Municipio")
    private String alcaldiaMunicipio;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "IDusuario")
    private Usuario usuario;
}
