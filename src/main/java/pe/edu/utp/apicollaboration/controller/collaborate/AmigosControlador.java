package pe.edu.utp.apicollaboration.controller.collaborate;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.amigos.UsuariosDto;
import pe.edu.utp.apicollaboration.model.entity.Curso;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.model.payload.MensajeResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AmigosControlador {

    @GetMapping("/amigos/{idUsuario}")
    public ResponseEntity<?> getUsuariosRecomendados(@PathVariable Long idUsuario) {

        List<UsuariosDto> usuarios = new ArrayList<UsuariosDto>();

        try {
            // Colocar la lógica
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/amigos/buscar")
    public ResponseEntity<?> busquedaUsuarios(@RequestParam String query) {

        List<UsuariosDto> usuarios = new ArrayList<UsuariosDto>();

        try {
            // Colocar la lógica
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/amigos/seguir/{idSeguido}/{idSeguidor}")
    public ResponseEntity<?> seguir(@PathVariable Long idSeguido, @PathVariable Long idSeguidor) {

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

    @PostMapping("/amigos/eliminar/{idSeguido}/{idSeguidor}")
    public ResponseEntity<?> dejarSeguir(@PathVariable Long idSeguido, @PathVariable Long idSeguidor) {

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
