package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDcliente")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_Paterno")
    private String apellido_Paterno;

    @Column(name = "apellido_Materno")
    private String apellido_Materno;

    @Column(name = "correo_Electronico")
    private String correo_Electronico;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "IDdomicilio")
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "IDmetodo_Pago")
    private MetodoPago metodoPago;
/*
    @OneToMany(mappedBy = "cliente",
            cascade = CascadeType.ALL)
    private Set<Tarjeta> tarjetas;

    @OneToMany(mappedBy = "cliente",
            cascade = CascadeType.ALL)
    private Set<Ticket> ticket;*/
}
