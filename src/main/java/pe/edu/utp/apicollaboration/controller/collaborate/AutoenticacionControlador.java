package pe.edu.utp.apicollaboration.controller.collaborate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.LoginDto;
import pe.edu.utp.apicollaboration.service.IAutenticacionService;

@RestController
@RequestMapping("/api/v1")
public class AutoenticacionControlador {
    @Autowired
    private IAutenticacionService autenticacionServicio;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        boolean autenticado = autenticacionServicio.autenticar(loginDto.codigo_universitario(), loginDto.contrasena());

        if (autenticado) {
            return ResponseEntity.ok(loginDto.codigo_universitario());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
