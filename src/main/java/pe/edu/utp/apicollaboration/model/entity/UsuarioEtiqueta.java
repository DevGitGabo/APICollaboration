package pe.edu.utp.collaborate.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "usuario_etiqueta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioEtiqueta {

    @EmbeddedId
    private UsuarioEtiquetaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etiqueta", insertable = false, updatable = false)
    private Etiqueta etiqueta;
}
