package pe.edu.utp.apicollaboration.controller.collaborate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.amigos.UsuariosDto;
import pe.edu.utp.apicollaboration.model.dto.feed.FeedDto;
import pe.edu.utp.apicollaboration.model.dto.feed.InvitacionesDto;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicacionesDto;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicarDto;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;
import pe.edu.utp.apicollaboration.model.payload.MensajeResponse;
import pe.edu.utp.apicollaboration.service.logic.FeedService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeedControlador {

    @Autowired
    private FeedService feedService;

    @GetMapping("/feed/{idUsuario}")
    public ResponseEntity<?> getFeed(@PathVariable Long idUsuario) {

        try {
            List<InvitacionesDto> invitaciones = feedService.listaInvitaciones(idUsuario);
            List<PublicacionesDto> publicaciones = feedService.listarPublicaciones(idUsuario);
            FeedDto feed = new FeedDto(invitaciones, publicaciones);

            return new ResponseEntity<>(feed, HttpStatus.OK);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/feed")
    public ResponseEntity<?> publicar(@RequestBody PublicarDto publicar) {

        try {
            feedService.guardarPublicacion(publicar);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/feed/invitacion")
    public ResponseEntity<?> responderInvitacion(@RequestBody InvitacionesDto invitaciones) {

        try {
            feedService.actualizarInvitaciones(invitaciones);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
