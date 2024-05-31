package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "usuario_metodo_pago_relacion")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioMetodoPagoRelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDusuario_metodo_pago_relacion")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IDusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "IDmetodo_Pago")
    private MetodoPago metodoPago;
}
