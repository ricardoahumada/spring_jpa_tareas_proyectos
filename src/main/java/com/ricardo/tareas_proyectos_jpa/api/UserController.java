package com.ricardo.tareas_proyectos_jpa.api;

import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import com.ricardo.tareas_proyectos_jpa.services.UsuaiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuaiosService usuaiosService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getAllUsers() {
        List<Usuario> users = usuaiosService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
