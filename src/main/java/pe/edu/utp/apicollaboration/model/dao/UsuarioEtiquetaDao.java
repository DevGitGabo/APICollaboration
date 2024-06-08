package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.utp.apicollaboration.model.entity.UsuarioEtiqueta;
import pe.edu.utp.apicollaboration.model.entity.UsuarioEtiquetaId;

public interface UsuarioEtiquetaDao extends CrudRepository<UsuarioEtiqueta, UsuarioEtiquetaId> {
}
