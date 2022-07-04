package com.ricardo.tareas_proyectos_jpa.persistence;

import com.ricardo.tareas_proyectos_jpa.models.Tarea;
import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TareasManager {
    @PersistenceContext
    private EntityManager em;

    public TareasManager() {
    }

    public List<Tarea> getTareas() throws Exception {
        List<Tarea> listaT = em.createQuery("FROM Tarea").getResultList();
        return listaT;
    }

    public Tarea getTareaById(Long id) throws Exception {
        return em.find(Tarea.class, id);
    }

    @Transactional
    public Tarea insertTarea(Tarea nuevaTarea) throws Exception {
        //No tiene id...es nulo
        em.persist(nuevaTarea);
        return nuevaTarea;
    }

    @Transactional
    public Tarea actualizarTarea(Tarea tareaAActualizar) throws Exception {
        //ya tiene un id
        em.merge(tareaAActualizar);
        return tareaAActualizar;
    }

}
