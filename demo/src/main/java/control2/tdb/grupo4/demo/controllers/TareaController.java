package control2.tdb.grupo4.demo.controllers;

import control2.tdb.grupo4.demo.models.Tarea;
import control2.tdb.grupo4.demo.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8086")
@RestController
public class TareaController {
    @Autowired
    TareaService tareaService;

    @PostMapping(value = "/tarea")
    public ResponseEntity crearTarea( @RequestBody Tarea tarea) {
        try {
            tareaService.crearTarea(tarea);
            return ResponseEntity.ok(null);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/edit-tarea/{id}")
    public ResponseEntity<Object> editarTarea(@PathVariable int id, @RequestBody Tarea tarea) {
        try {
            tareaService.update(tarea, id);
            return ResponseEntity.ok().body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @GetMapping("/tarea")
    public ResponseEntity<List<Tarea>> verTareas(){
        return ResponseEntity.ok((tareaService.verTareas()));
    }
}
