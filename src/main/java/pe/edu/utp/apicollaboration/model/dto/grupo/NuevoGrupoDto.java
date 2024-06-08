package pe.edu.utp.apicollaboration.model.dto.grupo;

import java.util.List;

public record NuevoGrupoDto(
        String nombre,
        String nombreTarea,
        Long idCurso,
        String descripcion,
        List<Long> idsUsuarios
) {
}
