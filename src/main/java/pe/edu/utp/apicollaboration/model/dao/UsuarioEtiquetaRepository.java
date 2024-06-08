package pe.edu.utp.collaborate.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.collaborate.model.entity.UsuarioEtiqueta;
import pe.edu.utp.collaborate.model.entity.UsuarioEtiquetaId;

@Repository
public interface UsuarioEtiquetaRepository extends CrudRepository<UsuarioEtiqueta, UsuarioEtiquetaId> {
}
