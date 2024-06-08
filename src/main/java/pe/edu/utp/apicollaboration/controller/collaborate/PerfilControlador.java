package pe.edu.utp.apicollaboration.controller.collaborate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.apicollaboration.model.dto.feed.FeedDto;
import pe.edu.utp.apicollaboration.model.dto.feed.InvitacionesDto;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicacionesDto;
import pe.edu.utp.apicollaboration.model.payload.MensajeResponse;
import pe.edu.utp.apicollaboration.service.logic.FeedService;
import pe.edu.utp.apicollaboration.service.logic.PerfilService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PerfilControlador {
    @Autowired
    private PerfilService perfilService;

    @GetMapping("/perfil/{idUsuario}")
    public ResponseEntity<?> getPerfil(@PathVariable Long idUsuario) {

        try {
            return new ResponseEntity<>(perfilService.getPerfil(idUsuario), HttpStatus.OK);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
