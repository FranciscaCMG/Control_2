package control2.tdb.grupo4.demo.repositories;

import control2.tdb.grupo4.demo.models.Usuario;
import  java.util.List;

public interface UsuarioRepository {

    public Usuario newUsuario(Usuario usuario);

    public boolean validaUsuario(String email, String pass);

    public List<Usuario> getAll();
    public void deleteUsuario(String rut);
}
