package control2.tdb.grupo4.demo.services;

import control2.tdb.grupo4.demo.models.Tarea;
import control2.tdb.grupo4.demo.repositories.TareaRepository;
import control2.tdb.grupo4.demo.models.Usuario;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class TareaService {

    private final control2.tdb.grupo4.demo.repositories.TareaRepository tareaRepository;

    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    @PostMapping("/tarea")
    @ResponseBody
    public Tarea crear(@RequestBody Tarea tarea){
        return tareaRepository.newTarea(tarea);
    }

    @GetMapping("/tareas")
    @ResponseBody
    public List<Tarea> verTareas(){
        return tareaRepository.getAll();
    }

}
