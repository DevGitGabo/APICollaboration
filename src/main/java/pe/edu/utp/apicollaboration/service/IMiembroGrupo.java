package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;

public interface IMiembroGrupo {
    MiembroGrupo save(MiembroGrupo miembroGrupo);
    MiembroGrupo findById(Long id);
    void delete(MiembroGrupo miembroGrupo);
}
