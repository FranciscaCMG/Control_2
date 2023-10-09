package control2.tdb.grupo4.demo.repositories;

import control2.tdb.grupo4.demo.models.Tarea;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TareaRepository {
    public Tarea newTarea(Tarea tarea);

    public List<Tarea> getAll();

    public Tarea update(Tarea tarea, int id_tarea, String titulo, String descripcion,
                        String fechaFin, String estado, String prioridad);

    public List<Tarea> findTitulo(int id_tarea, String titulo);

    public List<Tarea> findEstado(int id_tarea, String estado);
    public void delete(int id_tarea);
}
