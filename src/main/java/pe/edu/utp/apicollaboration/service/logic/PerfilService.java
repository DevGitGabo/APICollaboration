package pe.edu.utp.apicollaboration.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.apicollaboration.model.dto.perfil.PerfilDto;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.implementacion.IUsuario;

@Service
public class PerfilService {
    @Autowired
    private IUsuario usuarioService;
    public PerfilDto getPerfil(Long id) {
        Usuario usuario = usuarioService.findById(id);
        PerfilDto perfilDto = new PerfilDto(usuario);
        return perfilDto;
    }
}
