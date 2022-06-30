package com.ricardo.tareas_proyectos_jpa.persistence;

import com.ricardo.tareas_proyectos_jpa.config.SpringConfig;
import com.ricardo.tareas_proyectos_jpa.models.Tarea;
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
}