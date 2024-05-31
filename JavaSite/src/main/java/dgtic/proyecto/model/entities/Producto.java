package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDproducto")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "marca")
    private String marca;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "imagen")
    private String imagen;

    /*
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Carrito> carritos;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<TicketDetalle> ticketDetalles;
     */
}
