package control2.tdb.grupo4.demo.services;

import control2.tdb.grupo4.demo.repositories.UsuarioRepository;
import control2.tdb.grupo4.demo.models.Usuario;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class UsuarioService {

    private final control2.tdb.grupo4.demo.repositories.UsuarioRepository usuarioRepository;

    UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/usuario")
    @ResponseBody
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioRepository.newUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public List<Usuario> crear(){
        return usuarioRepository.getAll();
    }

}
