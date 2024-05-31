package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDticket")
    private int id;

    @Column(name = "fecha_Compra")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime fecha_Compra;

    @Column(name = "total_Compra")
    private double total_Compra;

    @Column(name = "fecha_Entrega")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fecha_Entrega;

    @ManyToOne
    @JoinColumn(name = "IDusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "IDmetodo_Pago")
    private MetodoPago metodoPago;

    /*@OneToMany(mappedBy = "ticket",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
            )
    private Set<TicketDetalle> detalles;*/
}
