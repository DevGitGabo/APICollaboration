package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "usuario_insignia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioInsignia {

    @EmbeddedId
    private UsuarioInsigniaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    @MapsId("idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_insignia", insertable = false, updatable = false)
    @MapsId("idInsignia")
    private Insignia insignia;
}
