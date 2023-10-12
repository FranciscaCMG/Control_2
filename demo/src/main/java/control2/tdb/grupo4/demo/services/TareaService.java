package control2.tdb.grupo4.demo.services;

import control2.tdb.grupo4.demo.models.Tarea;
import control2.tdb.grupo4.demo.repositories.TareaRepository;
import control2.tdb.grupo4.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    public Tarea crearTarea(Tarea tarea){
        return tareaRepository.newTarea(tarea);
    }

    public List<Tarea> verTareas(){
        return tareaRepository.getAll();
    }

    public Tarea update(Tarea tarea, int id){return tareaRepository.update(tarea,id);}

    public void delete(int id){tareaRepository.delete(id);}
}
