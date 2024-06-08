package pe.edu.utp.collaborate.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "publicacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacion;

    private String textoPublicacion;

    private String imagenPublicacion;

    @Column(nullable = false)
    private Long interacciones;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
