package pe.edu.utp.apicollaboration.service.implementacion;

import pe.edu.utp.apicollaboration.model.dto.grupo.GrupoDto;
import pe.edu.utp.apicollaboration.model.dto.grupo.NuevoGrupoDto;
import pe.edu.utp.apicollaboration.model.entity.Grupo;

import java.util.List;

public interface IGrupo {
    void save(NuevoGrupoDto nuevoGrupoDto, List<Long> idUsers);
    Grupo findById(Long id);
    void delete(Grupo grupo);
    List<Grupo> findGruposByUserId(Long id);
}
