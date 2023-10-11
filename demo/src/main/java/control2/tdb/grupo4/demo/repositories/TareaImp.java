package control2.tdb.grupo4.demo.repositories;

import control2.tdb.grupo4.demo.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Repository
public class TareaImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea newTarea(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Tarea(titulo, descripcion, fechaCreacion, fechaFin, estado, prioridad, rut)" +
                    "VALUES (:titulo, :descripcion, :fechaCreacion, :fechaFin, :estado, :prioridad, :rut)";
            conn.createQuery(sql, true)
                    .addParameter("titulo", tarea.getTitulo())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("fechaCreacion", tarea.getFechaCreacion())
                    .addParameter("fechaFin", tarea.getFechaFin())
                    .addParameter("estado", tarea.getEstado())
                    .addParameter("prioridad", tarea.getPrioridad())
                    .addParameter("rut", tarea.getRut())
                    .executeUpdate();
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Tarea ORDER BY id_tarea ASC")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea update(Tarea tarea, int id_tarea) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Tarea " +
                            "SET titulo = :titulo, descripcion = :descripcion, fechaFin = :fechaFin, " +
                            "estado = :estado, prioridad = :prioridad " +
                            "WHERE id_tarea = :id_tarea")
                    .addParameter("id_tarea", id_tarea)
                    .addParameter("titulo", tarea.getTitulo())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("fechaFin", tarea.getFechaFin())
                    .addParameter("estado", tarea.getEstado())
                    .addParameter("prioridad", tarea.getPrioridad())
                    .executeUpdate();
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> findTitulo(int id_tarea, String titulo) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Tarea WHERE id_tarea=:id_tarea AND titulo=:titulo")
                    .addParameter("titulo", titulo)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> findEstado(int id_tarea, String estado) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Tarea WHERE id_tarea=:id_tarea AND estado=:estado")
                    .addParameter("id_tarea", id_tarea)
                    .addParameter("estado", estado)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_tarea) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Tarea WHERE id_tarea=:id_tarea")
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Tarea.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
