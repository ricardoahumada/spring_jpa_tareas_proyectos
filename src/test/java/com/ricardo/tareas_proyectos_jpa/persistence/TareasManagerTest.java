package com.ricardo.tareas_proyectos_jpa.persistence;

import com.ricardo.tareas_proyectos_jpa.config.SpringConfig;
import com.ricardo.tareas_proyectos_jpa.models.Proyecto;
import com.ricardo.tareas_proyectos_jpa.models.Tarea;
import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(SpringConfig.class)
@ComponentScan("com.ricardo.tareas_proyectos_jpa.persistence")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Crea bbdd en memoria para pruebas, a partir de la bbdd real
class TareasManagerTest {

    @Autowired
    private TareasManager tManager;

    @Test
    void getTareas() {
        try {
            List<Tarea> tareas = tManager.getTareas();
            System.out.println(tareas);
            assertTrue(tareas != null);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }


    @Test
    void getTareaById() {
        try {
            Tarea tarea = tManager.getTareaById(2L);
            System.out.println(tarea);
            assertTrue(tarea != null);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    void insertTarea() {
        try {
            Proyecto proyectoExistente = new Proyecto();
            proyectoExistente.setPid(1L);
            Usuario usuarioExistente = new Usuario();
            usuarioExistente.setUid(2L);
            Tarea nuevaTarea = new Tarea(null, "Nueva tarea", 2, proyectoExistente, usuarioExistente);

            tManager.insertTarea(nuevaTarea);

            System.out.println(nuevaTarea);
            assertTrue(nuevaTarea != null && nuevaTarea.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    void actualizarTarea() {
        // actualizar nombre y propietario de la tarea 2
        try {
            Usuario usuarioExistente = new Usuario();
            usuarioExistente.setUid(3L);

            Tarea tareaQueYaExiste = tManager.getTareaById(2L);
            System.out.println(tareaQueYaExiste);

            tareaQueYaExiste.setNombre("Nuevo nombre de tarea");
            tareaQueYaExiste.setResponsable(usuarioExistente);

            tManager.actualizarTarea(tareaQueYaExiste);

            System.out.println(tareaQueYaExiste);
            assertTrue(tareaQueYaExiste != null && tareaQueYaExiste.getNombre().equals("Nuevo nombre de tarea"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}