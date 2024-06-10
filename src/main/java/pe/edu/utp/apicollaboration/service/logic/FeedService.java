package pe.edu.utp.apicollaboration.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.MiembroGrupoDao;
import pe.edu.utp.apicollaboration.model.dao.PublicacionDao;
import pe.edu.utp.apicollaboration.model.dto.feed.InvitacionesDto;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicacionesDto;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicarDto;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;
import pe.edu.utp.apicollaboration.service.implementacion.IPublicacion;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {
    @Autowired
    private MiembroGrupoDao miembroGrupoRepository;
    @Autowired
    private PublicacionDao publicacionRepository;
    @Autowired
    private IPublicacion publicacionService;

    public List<InvitacionesDto> listaInvitaciones(Long idUsuario) {
        List<MiembroGrupo> miembroGrupo= miembroGrupoRepository.findByUsuarioAndEstadoInvitado(idUsuario);

        List<InvitacionesDto> invitacionesDto = new ArrayList<InvitacionesDto>();
        for (MiembroGrupo grupo : miembroGrupo) {
            invitacionesDto.add(new InvitacionesDto(grupo));
        }

        return invitacionesDto;
    }

    public List<PublicacionesDto> listarPublicaciones(Long idUsuario){
        List<Publicacion> publicaciones = publicacionRepository.findPublicacionesByIdUsuarioAndSeguidores(idUsuario);

        List<PublicacionesDto> publicacionesDto = new ArrayList<PublicacionesDto>();

        for (Publicacion publicacion : publicaciones) {
            publicacionesDto.add(new PublicacionesDto(publicacion));
        }
        return publicacionesDto;
    }

    @Transactional
    public void guardarPublicacion(PublicarDto publicarDto){
        publicacionService.saveForDto(publicarDto);
    }

    public void actualizarInvitaciones(InvitacionesDto invitaciones) {
        MiembroGrupo miembroGrupo = miembroGrupoRepository.findById(invitaciones.idInvitacion()).orElse(null);

        assert miembroGrupo != null;

        if (invitaciones.estado_miembro().equals("ACEPTADO")){
            miembroGrupo.setEstadoMiembro("ACEPTADO");
            miembroGrupoRepository.save(miembroGrupo);
        }

        if (invitaciones.estado_miembro().equals("RECHAZADO")){
            miembroGrupoRepository.delete(miembroGrupo);
        }

    }
}
