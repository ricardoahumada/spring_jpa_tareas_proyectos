package com.ricardo.tareas_proyectos_jpa.persistence;

import com.ricardo.tareas_proyectos_jpa.models.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Properties;

public class UsuariosManager {
    private static SessionFactory sf = null;

    @PersistenceContext
    private EntityManager em;

    public UsuariosManager() throws Exception {

    }


    public List<Usuario> getUsuarios() throws Exception {
        List<Usuario> listaU = em.createQuery("FROM Usuario").getResultList();
        return listaU;
    }


}
