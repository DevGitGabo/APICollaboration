package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.Grupo;

public interface IGrupo {
    Grupo save(Grupo grupo);
    Grupo findById(Long id);
    void delete(Grupo grupo);
}
