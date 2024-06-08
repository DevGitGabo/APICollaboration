package pe.edu.utp.apicollaboration.model.dto.grupo;

import pe.edu.utp.apicollaboration.model.dto.miembroGrupo.MiembroGrupoDto;
import pe.edu.utp.apicollaboration.model.entity.Usuario;

import java.util.List;

public record GrupoDto(
        Long idgrupo,
        String nombreGrupo,
        String nombreTarea,
        String horario,
        String nombreCurso,
        String descripcion,
        List<MiembroGrupoDto> usuarioList

){
}
