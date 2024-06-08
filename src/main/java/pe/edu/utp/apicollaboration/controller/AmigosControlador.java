package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.amigos.UsuariosDto;
import pe.edu.utp.apicollaboration.model.entity.Curso;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.model.payload.MensajeResponse;
import pe.edu.utp.apicollaboration.service.logic.AmigosService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AmigosControlador {
    @Autowired
    private AmigosService amigosService;

    @GetMapping("/amigos/{idUsuario}")
    public ResponseEntity<?> getUsuariosRecomendados(@PathVariable Long idUsuario) {
        try {

            List<UsuariosDto> usuarios = amigosService.BuscarUsuariosMismoCurso(idUsuario);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);

        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/amigos/buscar")
    public ResponseEntity<?> busquedaUsuarios(@RequestParam String query, @RequestParam Long idUsuario) {

        try {
            List<UsuariosDto> usuarios = amigosService.BuscarUsuariosTexto(query, idUsuario);
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
            amigosService.seguir(idSeguido, idSeguidor);
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
            amigosService.dejarDeSeguir(idSeguido, idSeguidor);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
