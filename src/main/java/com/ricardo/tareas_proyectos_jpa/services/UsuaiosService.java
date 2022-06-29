package com.ricardo.tareas_proyectos_jpa.services;

import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import com.ricardo.tareas_proyectos_jpa.persistence.UsuariosManager;

import java.util.List;

public class UsuaiosService {
    private UsuariosManager usuariosManager;

    public void setUsuariosManager(UsuariosManager usuariosManager) {
        this.usuariosManager = usuariosManager;
    }

    public List<Usuario> getAllUsers() {
        try {
            return usuariosManager.getUsuarios();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
