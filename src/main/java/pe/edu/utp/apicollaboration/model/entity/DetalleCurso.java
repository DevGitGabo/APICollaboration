package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DetalleCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String estadoCurso;
}
