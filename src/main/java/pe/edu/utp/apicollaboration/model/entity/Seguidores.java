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
@Table(name = "seguidores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seguidores {

    @EmbeddedId
    private SeguidoresId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seguidor", insertable = false, updatable = false)
    private Usuario seguidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seguido", insertable = false, updatable = false)
    private Usuario seguido;
}
