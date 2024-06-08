package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "etiqueta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiqueta;

    @Column(nullable = false)
    private String nombreEtiqueta;

    @ManyToMany(mappedBy = "etiquetas")
    private List<Usuario> usuarios;
}
