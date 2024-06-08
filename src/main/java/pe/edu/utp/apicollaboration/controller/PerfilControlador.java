package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.apicollaboration.model.dto.perfil.ActualizarPerfilDto;
import pe.edu.utp.apicollaboration.model.payload.MensajeResponse;
import pe.edu.utp.apicollaboration.service.implementacion.impl.UsuarioImplService;
import pe.edu.utp.apicollaboration.service.logic.PerfilService;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.perfil.PerfilDto;

@RestController
@RequestMapping("/api/v1")
public class PerfilControlador {
    @Autowired
    private PerfilService perfilService;
    @Autowired
    private UsuarioImplService usuarioImplService;

    @GetMapping("/perfil/{idUsuario}")
    public ResponseEntity<?> getPerfil(@PathVariable Long idUsuario) {
        try {
            return new ResponseEntity<>(perfilService.getPerfil(idUsuario), HttpStatus.OK);
        } catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/perfil/{id}")
    public ResponseEntity<PerfilDto> getPerfilUserById(@PathVariable Long id){
        PerfilDto dtoPerfil = usuarioImplService.getPerfilUserById(id);
        return ResponseEntity.ok(dtoPerfil);
    }

    @PutMapping("/perfil/acercaDe")
    public ResponseEntity<?> updatePerfil(@RequestBody ActualizarPerfilDto ActualizarPerfilDTO){
        usuarioImplService.updateDescriptionPerfil(ActualizarPerfilDTO);
        return ResponseEntity.ok("Perfil actualizado correctamente");
    }
}
