package dgtic.proyecto.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDusuario", columnDefinition = "int", nullable = false, updatable = false)
    private int id;

    @Column(name = "nombre", columnDefinition = "varchar(50)", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido_Paterno", columnDefinition = "varchar(50)", length = 50, nullable = false)
    private String apellido_Paterno;

    @Column(name = "apellido_Materno", columnDefinition = "varchar(50)", length = 50, nullable = false)
    private String apellido_Materno;

    @Column(name = "correo", columnDefinition = "varchar(45)", length = 45, nullable = false, unique = true)
    private String correo;

    @Column(name = "password", columnDefinition = "varchar(64)", length = 64, nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "fecha_Creacion", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false, insertable = false)
    private LocalDateTime fecha_Creacion;

    @Column(name = "use_id_status", columnDefinition = "integer", nullable = false)
    private Integer useIdStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rol_usuario_relacion",
            joinColumns = @JoinColumn(name = "IDusuario"),
            inverseJoinColumns = @JoinColumn (name = "IDrol")
    )
    @JsonManagedReference
    private Set<Rol> useRoles = new HashSet<>();

    public String getFullName() {
        return this.nombre + ' ' + this.apellido_Paterno + ' ' + this.apellido_Materno;
    }

    /*@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Domicilio> domicilios;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tarjeta> tarjetas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> tickets;*/
}
