package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ticket_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDticket_detalle")
    private int id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "IDticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "IDproducto")
    private Producto producto;
}
