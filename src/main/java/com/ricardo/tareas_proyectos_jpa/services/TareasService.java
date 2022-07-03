package com.ricardo.tareas_proyectos_jpa.services;

import com.ricardo.tareas_proyectos_jpa.models.Tarea;
import com.ricardo.tareas_proyectos_jpa.persistence.TareasManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasService {
    @Autowired
    TareasManager tareasManager;

    public List<Tarea> getAllTareas() {
        try {
            return tareasManager.getTareas();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
