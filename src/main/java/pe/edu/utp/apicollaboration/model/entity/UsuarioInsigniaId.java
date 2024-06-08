package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioInsigniaId implements Serializable {

    private Long idUsuario;
    private Long idInsignia;
}
