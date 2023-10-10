package control2.tdb.grupo4.demo.controllers;

import control2.tdb.grupo4.demo.models.Usuario;
import control2.tdb.grupo4.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "/usuario")
    public ResponseEntity  crearUsuario( @RequestBody Usuario usuario ) {
        try{
            usuarioService.crearUsuario(usuario);
            return ResponseEntity.ok(null);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllVoluntarios(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }


}
