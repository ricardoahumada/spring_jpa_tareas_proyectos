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

    @Autowired
    private UsuariosManager usuariosManager;

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
            usuariosManager.createUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
