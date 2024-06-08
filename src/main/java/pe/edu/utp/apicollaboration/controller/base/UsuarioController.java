package pe.edu.utp.apicollaboration.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.model.payload.MensajeResponse;
import pe.edu.utp.apicollaboration.service.IUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            Usuario usuarioDelete = usuarioService.findById(id);
            usuarioService.delete(usuarioDelete);
            return new ResponseEntity<>(usuarioDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder().
                    mensaje(exDt.getMessage()).
                    object(null).
                    build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario showById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAll() {
        List<Usuario> usuarios = usuarioService.listAll();
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(usuarios)
                        .build(),
                HttpStatus.OK);
    }
}
