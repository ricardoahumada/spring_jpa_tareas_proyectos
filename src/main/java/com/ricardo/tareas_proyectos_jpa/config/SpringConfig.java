package com.ricardo.tareas_proyectos_jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ReposConfig.class, ServicesConfig.class})
public class SpringConfig {


}
