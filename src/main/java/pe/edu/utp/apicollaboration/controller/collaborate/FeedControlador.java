package pe.edu.utp.apicollaboration.controller.collaborate;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.amigos.UsuariosDto;
import pe.edu.utp.apicollaboration.model.dto.feed.FeedDto;
import pe.edu.utp.apicollaboration.model.dto.feed.InvitacionesDto;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicacionesDto;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicarDto;
import pe.edu.utp.apicollaboration.model.payload.MensajeResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeedControlador {

    @GetMapping("/feed/{idUsuario}")
    public ResponseEntity<?> getFeed(@PathVariable Long idUsuario) {

        List<InvitacionesDto> invitaciones = new ArrayList<InvitacionesDto>();
        List<PublicacionesDto> publicaciones = new ArrayList<PublicacionesDto>();
        FeedDto feed = new FeedDto(invitaciones, publicaciones);

        try {
            // Colocar la lógica
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
            // Colocar la lógica
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
            // Colocar la lógica
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
