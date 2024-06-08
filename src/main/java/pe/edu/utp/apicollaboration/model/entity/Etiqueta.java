package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "etiqueta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiqueta;

    @Column(nullable = false)
    private String nombreEtiqueta;

    @ManyToMany(mappedBy = "etiquetas")
    private List<Usuario> usuarios;
}
