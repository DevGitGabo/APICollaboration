package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.CursoDao;
import pe.edu.utp.apicollaboration.model.dao.GrupoDao;
import pe.edu.utp.apicollaboration.model.dao.MiembroGrupoDao;
import pe.edu.utp.apicollaboration.model.dao.UsuarioDao;
import pe.edu.utp.apicollaboration.model.dto.grupo.GrupoDto;
import pe.edu.utp.apicollaboration.model.dto.grupo.NuevoGrupoDto;
import pe.edu.utp.apicollaboration.model.entity.Curso;
import pe.edu.utp.apicollaboration.model.entity.Grupo;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.IGrupo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoImplService implements IGrupo {

    @Autowired
    private GrupoDao grupoDao;
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private MiembroGrupoDao miembroGrupoDao;
    @Autowired
    private CursoDao cursoDao;

    @Override
    @Transactional
    public void save(NuevoGrupoDto nuevoGrupoDto, List<Long> idUsers) {
        Grupo grupoNuevo = new Grupo();

        Optional<Curso> cursoOptional = cursoDao.findCursoById_curso(nuevoGrupoDto.idCurso());
        grupoNuevo.setCurso(cursoOptional.get());
        grupoNuevo.setNombreGrupo(nuevoGrupoDto.nombre());
        grupoNuevo.setDescripcion(nuevoGrupoDto.descripcion());
        grupoNuevo.setNombreTarea(nuevoGrupoDto.nombreTarea());

        grupoDao.save(grupoNuevo);

        for(Long iduser: idUsers){
            Usuario usuario = usuarioDao.findById(iduser)
                    .orElseThrow(()->new IllegalArgumentException("Usuario no se puede agregar porque no existe"));

            MiembroGrupo miembroGrupo = new MiembroGrupo();
            miembroGrupo.setUsuario(usuario);
            miembroGrupo.setGrupo(grupoNuevo);
            miembroGrupo.setRol("Lider");
            miembroGrupo.setEstadoMiembro("INVITADO");
            miembroGrupo.setNumVotosMvp(0L);
            miembroGrupoDao.save(miembroGrupo);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Grupo findById(Long id) {
        return grupoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Grupo grupo) {
        grupoDao.delete(grupo);
    }

    @Override
    public List<Grupo> findGruposByUserId(Long idUser) {
        List<Grupo> gruposForUser = grupoDao.findAllByIdUser(idUser);
        return gruposForUser;
    }
}
