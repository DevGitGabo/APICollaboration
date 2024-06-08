package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.UsuarioEtiqueta;
import pe.edu.utp.apicollaboration.service.IUsuarioEtiqueta;

@RestController
@RequestMapping("/api/v1")
public class UsuarioEtiquetaController {

    @Autowired
    private IUsuarioEtiqueta usuarioEtiquetaService;

    @PostMapping("/usuarioEtiqueta")
    public UsuarioEtiqueta create(@RequestBody UsuarioEtiqueta usuarioEtiqueta) {
        return usuarioEtiquetaService.save(usuarioEtiqueta);
    }

    @PutMapping("/usuarioEtiqueta")
    public UsuarioEtiqueta update(@RequestBody UsuarioEtiqueta usuarioEtiqueta) {
        return usuarioEtiquetaService.save(usuarioEtiqueta);
    }

    @DeleteMapping("/usuarioEtiqueta/{idUsuario}/{idEtiqueta}")
    public void delete(@PathVariable Long idUsuario, @PathVariable Long idEtiqueta) {
        UsuarioEtiqueta usuarioEtiqueta = usuarioEtiquetaService.findById(idUsuario, idEtiqueta);
        usuarioEtiquetaService.delete(usuarioEtiqueta);
    }

    @GetMapping("/usuarioEtiqueta/{idUsuario}/{idEtiqueta}")
    public UsuarioEtiqueta showById(@PathVariable Long idUsuario, @PathVariable Long idEtiqueta) {
        return usuarioEtiquetaService.findById(idUsuario, idEtiqueta);
    }
}
