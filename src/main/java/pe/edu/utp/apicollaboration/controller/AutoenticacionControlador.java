package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dto.LoginDto;
import pe.edu.utp.apicollaboration.service.implementacion.IAutenticacionService;
import pe.edu.utp.apicollaboration.service.logic.AutoenticacionService;
/*import pe.edu.utp.apicollaboration.service.logic.AutoenticacionService;*/

@RestController
@RequestMapping("/api/v1")
public class AutoenticacionControlador {

    @Autowired
    private AutoenticacionService autenticacionServicio;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        boolean autenticado = autenticacionServicio.isAutenticacion(loginDto);

        if (autenticado) {
            return ResponseEntity.ok(autenticacionServicio.usuario(loginDto));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
