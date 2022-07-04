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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Tarea getTarea(Long id) {
        try {
            return tareasManager.getTareaById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Tarea createTarea(Tarea newTarea) {
        try {
            return tareasManager.insertTarea(newTarea);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Tarea actualizarTarea(Tarea unaTareaParcial) {
        try {
            Tarea tareaExistente = tareasManager.getTareaById(unaTareaParcial.getId());

            tareaExistente.actualizar(unaTareaParcial);

            return tareasManager.actualizarTarea(tareaExistente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
