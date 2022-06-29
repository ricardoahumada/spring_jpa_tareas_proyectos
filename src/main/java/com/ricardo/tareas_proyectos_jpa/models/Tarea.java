package com.ricardo.tareas_proyectos_jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

public class Tarea {
    private int id;


    private String nombre;


    private double duracion;


    private Proyecto proyecto;


    private int pid;


    private Usuario responsable = new Usuario(1, "", "", "");

    public Tarea() {

    }

    public Tarea(int id, String nombre, double duracion, Proyecto proyecto, Usuario responsable) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.proyecto = proyecto;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public int getPid() {
        this.pid = this.proyecto.getPid();
        return pid;
    }

    public void setPid(int pid) throws Exception {
        this.pid = pid;
    }


}
