package com.ricardo.tareas_proyectos_jpa.persistence;

import com.ricardo.tareas_proyectos_jpa.config.SpringConfig;
import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(SpringConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Crea bbdd en memoria para pruebas, a partir de la bbdd real
class UsuariosManagerTest {

    @Autowired
    UsuariosManager usuariosManager;

    @Test
    void getUsuarios() {

        try {
            List<Usuario> usuarios = usuariosManager.getUsuarios();
            System.out.println(usuarios);
            assertTrue(usuarios != null);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    @Test
    void getUserById() {
        try {
            Usuario user = usuariosManager.getUser(2L);
            System.out.println(user);
            assertEquals(user.getUid(), 2L);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    @Test
    void createUser() {
        Usuario nuevo = new Usuario("Juan", "j@j.com", "xxxx", "f.jpeg");

        try {
            System.out.println(nuevo);
            Long newId = usuariosManager.createUser(nuevo);
            System.out.println(newId);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    @Test
    void updateUser() {
        Usuario usuario = new Usuario(1L, "Juan", "j@j.com", "xxxx", "f.jpeg");

        try {
            Usuario actualizado = usuariosManager.updateUser(usuario);
            System.out.println(actualizado);
            assertEquals(actualizado.getNombre(), usuario.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    @Test
    void deleteUser() {

        try {
            boolean isOk = usuariosManager.deleteUser(1L);
            assertTrue(isOk);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }
}