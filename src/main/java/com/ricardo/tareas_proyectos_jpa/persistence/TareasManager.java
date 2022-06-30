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


}
