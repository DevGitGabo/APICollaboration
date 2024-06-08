package pe.edu.utp.apicollaboration.controller.collaborate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.perfil.ActualizarPerfilDto;
import pe.edu.utp.apicollaboration.model.dto.perfil.PerfilDto;
import pe.edu.utp.apicollaboration.service.impl.UsuarioImplService;

@RestController
@RequestMapping("/api/v1")
public class PerfilControlador {
    @Autowired
    private UsuarioImplService usuarioImplService;
    @GetMapping("Perfil/{id}")
    public ResponseEntity<PerfilDto> getPerfilUserById(@PathVariable Long id){
        PerfilDto dtoPerfil = usuarioImplService.getPerfilUserById(id);
        return ResponseEntity.ok(dtoPerfil);
    }

    @PutMapping("Perfil/acercaDe")
    public ResponseEntity<?> updatePerfil(@RequestBody ActualizarPerfilDto ActualizarPerfilDTO){
        usuarioImplService.updateDescriptionPerfil(ActualizarPerfilDTO);
        return ResponseEntity.ok("Perfil actualizado correctamente");
    }
}
