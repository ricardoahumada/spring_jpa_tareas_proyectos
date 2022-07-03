package com.ricardo.tareas_proyectos_jpa.persistence;

import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Properties;

public class UsuariosManager {
    @PersistenceContext
    private EntityManager em;

    public UsuariosManager() {
    }

    public List<Usuario> getUsuarios() throws Exception {
        List<Usuario> listaU = em.createQuery("FROM Usuario").getResultList();
        return listaU;
    }

    public Usuario getUser(Long uid) throws Exception {
        return em.find(Usuario.class, uid);
    }

    @Transactional
    public Long createUser(Usuario newUser) throws Exception {
        em.persist(newUser);
        return newUser.getUid();
    }

    @Transactional
    public Usuario updateUser(Usuario existingUser) throws Exception {
        return em.merge(existingUser);
    }

    @Transactional
    public boolean deleteUser(long uid) throws Exception {
        Usuario usaurioABorrar = getUser(uid);
        em.remove(usaurioABorrar);
        return true;
    }


}
