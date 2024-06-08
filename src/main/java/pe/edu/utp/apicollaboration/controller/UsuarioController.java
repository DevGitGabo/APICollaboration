package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.IUsuario;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @PostMapping("/usuario")
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuario")
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        usuarioService.delete(usuario);
    }

    @GetMapping("/usuario/{id}")
    public Usuario showById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
}
