package pe.edu.utp.apicollaboration.service.implementacion;

import pe.edu.utp.apicollaboration.model.entity.Seguidores;

public interface ISeguidores {
    Seguidores save(Seguidores seguidores);
    Seguidores findById(Long idSeguidor, Long idSeguido);
    void delete(Seguidores seguidores);
}
