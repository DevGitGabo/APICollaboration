package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Column(nullable = false)
    private String codigoCurso;

    @Column(nullable = false)
    private String nombreCurso;

    private String horario;

    private String imagenCurso;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCurso> detalleCursos;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grupo> grupos;
}
