package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seguidores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Seguidores {

    @EmbeddedId
    private SeguidoresId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seguidor", insertable = false, updatable = false)
    @MapsId("idSeguidor")
    private Usuario seguidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seguido", insertable = false, updatable = false)
    @MapsId("idSeguido")
    private Usuario seguido;
}
