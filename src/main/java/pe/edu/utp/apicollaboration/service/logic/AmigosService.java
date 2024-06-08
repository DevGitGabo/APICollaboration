package pe.edu.utp.apicollaboration.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.SeguidoresDao;
import pe.edu.utp.apicollaboration.model.dao.UsuarioDao;
import pe.edu.utp.apicollaboration.model.dto.amigos.UsuariosDto;
import pe.edu.utp.apicollaboration.model.entity.*;
import pe.edu.utp.apicollaboration.service.ICurso;
import pe.edu.utp.apicollaboration.service.IDetalleCurso;
import pe.edu.utp.apicollaboration.service.ISeguidores;
import pe.edu.utp.apicollaboration.service.IUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AmigosService {
    @Autowired
    private IUsuario usuarioService;
    @Autowired
    private UsuarioDao usuarioRepository;
    @Autowired
    private SeguidoresDao seguidoresRepository;
    @Autowired
    private ISeguidores seguidoresService;

    public List<UsuariosDto> BuscarUsuariosMismoCurso(Long idUsuario) {
        List<Usuario> usuarios = usuarioService.listarUsuariosMismosCursos(idUsuario);
        List<UsuariosDto> usuariosDto = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            // Verificar si el usuario actual es seguidor
            boolean esSeguidor = esSeguidor(idUsuario, usuario.getIdUser());
            usuariosDto.add(new UsuariosDto(usuario, esSeguidor));
        }

        return usuariosDto;
    }

    public List<UsuariosDto> BuscarUsuariosTexto(String texto, Long idUsuario) {

        List<Usuario> usuarios = usuarioRepository.findUsuariosByNombreOrApellido(texto, idUsuario);
        List<UsuariosDto> usuariosDto = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            // Verificar si el usuario actual es seguidor
            boolean esSeguidor = esSeguidor(idUsuario, usuario.getIdUser());
            usuariosDto.add(new UsuariosDto(usuario, esSeguidor));
        }

        return usuariosDto;
    }

    private boolean esSeguidor(Long idSeguidor, Long idSeguido) {
        Optional<Seguidores> seguidoresOptional = seguidoresRepository.findById(new SeguidoresId(idSeguidor, idSeguido));
        return seguidoresOptional.isPresent();
    }

    public void seguir(Long idSeguidor, Long idSeguido) {
        SeguidoresId nuevoSeguimientoId = new SeguidoresId(idSeguidor, idSeguido);
        Usuario seguidor = usuarioService.findById(idSeguidor);
        Usuario seguido = usuarioService.findById(idSeguido);

        Seguidores nuevoSeguimiento = Seguidores.builder()
                .id(nuevoSeguimientoId)
                .seguidor(seguidor)
                .seguido(seguido)
                .build();

        seguidoresService.save(nuevoSeguimiento);
    }

    public void dejarDeSeguir(Long idSeguidor, Long idSeguido) {
        Seguidores seguimiento = seguidoresService.findById(idSeguidor, idSeguido);
        seguidoresService.delete(seguimiento);
    }


}
