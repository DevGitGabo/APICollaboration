package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.dto.perfil.ActualizarPerfilDto;
import pe.edu.utp.apicollaboration.model.dto.perfil.PerfilDto;
import pe.edu.utp.apicollaboration.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listAll();
    Usuario save (Usuario usuario);
    Usuario findById (Long id);
    void delete (Usuario usuario);

    PerfilDto getPerfilUserById(Long id);

    void updateDescriptionPerfil(ActualizarPerfilDto ActualizarPerfilDTO);
}
