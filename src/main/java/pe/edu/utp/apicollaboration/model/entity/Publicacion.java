package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "publicacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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
