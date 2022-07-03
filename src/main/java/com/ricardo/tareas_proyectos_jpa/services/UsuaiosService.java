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

    public Usuario getUserById(Long uid) {
        try {
            return usuariosManager.getUser(uid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario addUser(Usuario u) {
        try {
            usuariosManager.createUser(u);
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario updateUser(Usuario u) throws IllegalArgumentException {
        try {
            Usuario existing = usuariosManager.getUser(u.getUid());
            if (existing == null) {
                throw new IllegalArgumentException("Usuari amb id " + u.getUid() + " no existeix");
            }
            existing.actualizarPropiedadsPublicas(u);
            return usuariosManager.updateUser(existing);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUser(long id) {
        try {
            return usuariosManager.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
