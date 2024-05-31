package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "carrito")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDcarrito")
    private int id;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "IDproducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "IDusuario")
    private Usuario usuario;
}
