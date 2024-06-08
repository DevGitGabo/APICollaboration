package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "miembro_grupo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MiembroGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMiembro;

    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String rol;

    @Column(nullable = false)
    private Long numVotosMvp;

    private String estadoMiembro;
}
