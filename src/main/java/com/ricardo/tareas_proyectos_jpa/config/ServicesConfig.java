package com.ricardo.tareas_proyectos_jpa.config;

import com.ricardo.tareas_proyectos_jpa.persistence.UsuariosManager;
import com.ricardo.tareas_proyectos_jpa.services.UsuaiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ServicesConfig {
    @Autowired
    UsuariosManager repoUsers;

    @Bean
    public UsuaiosService crearBeanUsuaiosService() {
        UsuaiosService us = new UsuaiosService();
        us.setUsuariosManager(repoUsers);
        return us;
    }

}
