package com.ricardo.tareas_proyectos_jpa.api;

import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import com.ricardo.tareas_proyectos_jpa.persistence.UsuariosManager;
import com.ricardo.tareas_proyectos_jpa.services.UsuaiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuaiosService usuariosService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getAllUsers() {

        List<Usuario> users = usuariosService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getUserById(@PathVariable Long uid) {
        Usuario user = usuariosService.getUserById(uid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario user) {
        try {
            user.setUid(null);
            usuariosService.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(value = "/{uid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> updateUser(@PathVariable Long uid, @RequestBody Usuario user) {
        try {
            user.setUid(uid);
            Usuario ret = usuariosService.updateUser(user);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } catch (RuntimeException e) {
            // L'usuari no existeix
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> deleteUser(@PathVariable Long uid) {
        usuariosService.deleteUser(uid);
        return ResponseEntity.noContent().build();
    }

}
