package control2.tdb.grupo4.demo.services;

import control2.tdb.grupo4.demo.repositories.TareaRepository;
import control2.tdb.grupo4.demo.repositories.UsuarioImp;
import control2.tdb.grupo4.demo.repositories.UsuarioRepository;
import control2.tdb.grupo4.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Service
public class UsuarioService {
    @Autowired
     UsuarioRepository usuarioRepository;
    public void crearUsuario(Usuario usuario){
        usuarioRepository.newUsuario(usuario);
    }

    public void login(String correo, String pass){
        usuarioRepository.validaUsuario(correo,pass);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.getAll();
    }


}
