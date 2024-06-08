package pe.edu.utp.apicollaboration.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.apicollaboration.model.dao.UsuarioDao;
import pe.edu.utp.apicollaboration.model.dto.LoginDto;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.implementacion.IAutenticacionService;
import pe.edu.utp.apicollaboration.service.implementacion.IUsuario;

@Service
public class AutoenticacionService {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private IAutenticacionService autenticacionServicio;

    public boolean isAutenticacion(LoginDto loginDto) {
        return autenticacionServicio.autenticar(loginDto.codigo_universitario(), loginDto.contrasena());
    }

    public Long usuario(LoginDto loginDto) {
        Usuario user = usuarioDao.findByCodigoUniversitario(loginDto.codigo_universitario())
                .orElseThrow(() -> new IllegalArgumentException(("No se encontro el usuario")));

        return user.getIdUser();
    }
}
