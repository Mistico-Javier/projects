package dgtic.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "tarjeta")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDtarjeta")
    private int id;

    @Column(name = "nombre_Persona_Tarjeta")
    private String nombrePersonaTarjeta;

    @Column(name = "numero_Tarjeta")
    private String numeroTarjeta;

    @Column(name = "tipo_Tarjeta")
    private String tipoTarjeta;

    @Column(name = "vencimiento_Tarjeta")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime vencimientoTarjeta;

    @ManyToOne
    @JoinColumn(name = "IDusuario")
    private Usuario usuario;
}
