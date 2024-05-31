package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity(name = "metodo_Pago")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDmetodo_Pago")
    private int id;

    @Column(name = "metodo_Pago")
    private String metodoPago;

    /*
    @OneToMany(mappedBy = "metodoPago", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
     */
}
