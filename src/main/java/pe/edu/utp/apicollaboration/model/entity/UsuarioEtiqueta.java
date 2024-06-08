package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_etiqueta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UsuarioEtiqueta {

    @EmbeddedId
    private UsuarioEtiquetaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    @MapsId("idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etiqueta", insertable = false, updatable = false)
    @MapsId("idEtiqueta")
    private Etiqueta etiqueta;
}
