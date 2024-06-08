package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.UsuarioInsignia;
import pe.edu.utp.apicollaboration.service.IUsuarioInsignia;

@RestController
@RequestMapping("/api/v1")
public class UsuarioInsigniaController {

    @Autowired
    private IUsuarioInsignia usuarioInsigniaService;

    @PostMapping("/usuarioInsignia")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioInsignia create(@RequestBody UsuarioInsignia usuarioInsignia) {
        return usuarioInsigniaService.save(usuarioInsignia);
    }

    @PutMapping("/usuarioInsignia")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioInsignia update(@RequestBody UsuarioInsignia usuarioInsignia) {
        return usuarioInsigniaService.save(usuarioInsignia);
    }

    @DeleteMapping("/usuarioInsignia/{idUsuario}/{idInsignia}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idUsuario, @PathVariable Long idInsignia) {
        UsuarioInsignia usuarioInsignia = usuarioInsigniaService.findById(idUsuario, idInsignia);
        usuarioInsigniaService.delete(usuarioInsignia);
    }

    @GetMapping("/usuarioInsignia/{idUsuario}/{idInsignia}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioInsignia showById(@PathVariable Long idUsuario, @PathVariable Long idInsignia) {
        return usuarioInsigniaService.findById(idUsuario, idInsignia);
    }
}
