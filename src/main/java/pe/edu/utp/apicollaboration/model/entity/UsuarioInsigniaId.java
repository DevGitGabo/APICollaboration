package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInsigniaId implements Serializable {

    private Long idUsuario;
    private Long idInsignia;
}
