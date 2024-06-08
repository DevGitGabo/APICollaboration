package pe.edu.utp.collaborate.model.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEtiquetaId implements Serializable {

    private Long idUsuario;
    private Long idEtiqueta;
}
