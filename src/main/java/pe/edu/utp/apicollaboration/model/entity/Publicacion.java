package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicarDto;

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

    public Publicacion(PublicarDto publicarDto, Usuario usuario) {
        this.idPublicacion = 1L;
        this.textoPublicacion = publicarDto.texto();
        this.imagenPublicacion = null;
        this.interacciones = 0L;
        this.usuario = usuario;
    }
}
