package pe.edu.utp.apicollaboration.service.implementacion;

import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;

public interface IMiembroGrupo {
    MiembroGrupo save(MiembroGrupo miembroGrupo);
    MiembroGrupo findById(Long id);
    void delete(MiembroGrupo miembroGrupo);
}
