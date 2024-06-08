package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.Usuario;

import java.util.List;

public interface IUsuario {
    List<Usuario> listAll();
    List<Usuario> listarUsuariosMismosCursos(Long idUsuario);

    Usuario save (Usuario usuario);
    Usuario findById (Long id);
    void delete (Usuario usuario);
}
