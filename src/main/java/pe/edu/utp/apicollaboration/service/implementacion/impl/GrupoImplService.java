package pe.edu.utp.apicollaboration.service.implementacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.CursoDao;
import pe.edu.utp.apicollaboration.model.dao.GrupoDao;
import pe.edu.utp.apicollaboration.model.dao.MiembroGrupoDao;
import pe.edu.utp.apicollaboration.model.dao.UsuarioDao;
import pe.edu.utp.apicollaboration.model.dto.grupo.NuevoGrupoDto;
import pe.edu.utp.apicollaboration.model.entity.Curso;
import pe.edu.utp.apicollaboration.model.entity.Grupo;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.implementacion.IGrupo;

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
        // Validar que se hayan proporcionado datos y que la lista de usuarios no esté vacía
        if (nuevoGrupoDto == null || idUsers == null || idUsers.isEmpty()) {
            throw new IllegalArgumentException("Datos insuficientes para crear el grupo.");
        }

        // Obtener el curso
        Curso curso = cursoDao.findCursoById_curso(nuevoGrupoDto.idCurso())
                .orElseThrow(() ->
                        new IllegalArgumentException("Curso no encontrado para el ID: "
                        + nuevoGrupoDto.idCurso()));

        // Crear el grupo
        Grupo grupoNuevo = new Grupo();
        grupoNuevo.setCurso(curso);
        grupoNuevo.setNombreGrupo(nuevoGrupoDto.nombre());
        grupoNuevo.setDescripcion(nuevoGrupoDto.descripcion());
        grupoNuevo.setNombreTarea(nuevoGrupoDto.nombreTarea());

        grupoDao.save(grupoNuevo);

        // Asignar usuarios al grupo
        for (Long idUser : idUsers) {
            // Verificar si el usuario existe
            Usuario usuario = usuarioDao.findById(idUser)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Usuario no encontrado para el ID: " + idUser));

            // Crear y guardar el miembro del grupo
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
