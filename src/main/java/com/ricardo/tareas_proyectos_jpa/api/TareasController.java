package com.ricardo.tareas_proyectos_jpa.api;

import com.ricardo.tareas_proyectos_jpa.models.StatusMessage;
import com.ricardo.tareas_proyectos_jpa.models.Tarea;
import com.ricardo.tareas_proyectos_jpa.services.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareasController {
    @Autowired
    private TareasService tareasService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tarea>> getAllUsers() {

        List<Tarea> users = tareasService.getAllTareas();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTarea(@PathVariable Long id) {
        Tarea tarea = tareasService.getTarea(id);
        if (tarea != null) return new ResponseEntity<>(tarea, HttpStatus.OK);
        else
            return new ResponseEntity<>(new StatusMessage(HttpStatus.NOT_FOUND.value(), "No encontrado"), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTarea(@RequestBody @Valid Tarea nuevaT) {
        tareasService.createTarea(nuevaT);
        if (nuevaT != null && nuevaT.getId() > 0) return new ResponseEntity<>(nuevaT, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(new StatusMessage(HttpStatus.BAD_REQUEST.value(), "No encontrado"), HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTarea(@RequestBody @Valid Tarea tareaExistente) {
        tareasService.actualizarTarea(tareaExistente);
        if (tareaExistente != null) return new ResponseEntity(tareaExistente, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(new StatusMessage(HttpStatus.NOT_MODIFIED.value(), "No modificado"), HttpStatus.NOT_MODIFIED);
    }

}
