package com.ricardo.tareas_proyectos_jpa.api;

import com.ricardo.tareas_proyectos_jpa.models.Tarea;
import com.ricardo.tareas_proyectos_jpa.services.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
