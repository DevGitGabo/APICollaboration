package pe.edu.utp.collaborate.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "grupo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private String nombreGrupo;

    private String descripcion;

    private String nombreTarea;

    private Boolean estadoGrupo;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MiembroGrupo> miembroGrupos;
}
