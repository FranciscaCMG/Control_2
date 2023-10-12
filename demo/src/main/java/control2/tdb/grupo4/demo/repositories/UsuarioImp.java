package control2.tdb.grupo4.demo.repositories;

import control2.tdb.grupo4.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UsuarioImp implements UsuarioRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public void newUsuario(Usuario usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO  Usuario(rut, nombres, apellidos, email, pass)" +
                    "VALUES (:rut,:nombres,:apellidos,:email,:pass)";
            conn.createQuery(sql, true)
                    .addParameter("rut", String.valueOf(usuario.getRut()))
                    .addParameter("nombres", usuario.getNombres())
                    .addParameter("apellidos", usuario.getApellidos())
                    .addParameter("email", usuario.getEmail())
                    .addParameter("pass", usuario.getPass())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean validaUsuario(String email, String pass) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM Usuario WHERE email = :email AND pass = :pass";
            conn.createQuery(sql, true)
                    .addParameter("email", email)
                    .addParameter("pass", pass);
            return true; // if the user exists, return true
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Usuario> getAll(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario ORDER BY rut ASC")
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteUsuario(String rut){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Usuario WHERE rut=:rut")
                    .addParameter("rut", rut)
                    .executeAndFetch(Usuario.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
