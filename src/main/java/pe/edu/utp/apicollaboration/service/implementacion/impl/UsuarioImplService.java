package pe.edu.utp.apicollaboration.service.implementacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.UsuarioDao;
import pe.edu.utp.apicollaboration.model.dto.perfil.ActualizarPerfilDto;
import pe.edu.utp.apicollaboration.model.dto.perfil.PerfilDto;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.Encrypt.Encryption;
import pe.edu.utp.apicollaboration.service.implementacion.IAutenticacionService;
import pe.edu.utp.apicollaboration.service.implementacion.IUsuario;


import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service

public class UsuarioImplService implements IUsuario, IAutenticacionService {


    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listAll() {
        return (List) usuarioDao.findAll();
    }

    @Override
    public List<Usuario> listarUsuariosMismosCursos(Long idUsuario) {
        return usuarioDao.findUsuariosInSameCourses(idUsuario);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public PerfilDto getPerfilUserById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void updateDescriptionPerfil(ActualizarPerfilDto ActualizarPerfilDTO) {
        Usuario user = findById(ActualizarPerfilDTO.id());
        user.setDescripcion(ActualizarPerfilDTO.descripcion());
        usuarioDao.save(user);
    }

    @Override
    public boolean autenticar(String usuario, String password) {
        Optional<Usuario> userOptional = usuarioDao.findByCodigoUniversitario(usuario);

        if (userOptional.isEmpty()) {
            return false;
        }

        Usuario user = userOptional.get();
        String hashedPasswordFromDatabase = user.getContrasena();

        return BCrypt.checkpw(password, hashedPasswordFromDatabase);
    }
}
