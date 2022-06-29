package com.ricardo.tareas_proyectos_jpa.config;

import com.ricardo.tareas_proyectos_jpa.persistence.UsuariosManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReposConfig {
    @Bean
    public UsuariosManager crearBeanUserRepo() {
        try {
            return new UsuariosManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
