package com.ricardo.tareas_proyectos_jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private double duracion;
    @ManyToOne
    @JoinColumn(name="project",nullable = false)
    private Proyecto proyecto;
    @Column
    private int pid;

    @ManyToOne
    @JoinColumn(name="responsable",nullable = false)
    private Usuario responsable;

    @ManyToMany
    @JoinTable(
            name = "task_participants",
            joinColumns = @JoinColumn(name="task",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user",nullable = false)
    )
    private List<Usuario> participantes;

    public Tarea() {

    }

    public Tarea(Long id, String nombre, double duracion, Proyecto proyecto, Usuario responsable) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.proyecto = proyecto;
        this.responsable = responsable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        this.pid = this.proyecto.getPid().intValue();
        return pid;
    }

    public void setPid(int pid) throws Exception {
        this.pid = pid;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", proyecto=" + proyecto +
                ", pid=" + pid +
                ", responsable=" + responsable +
                ", participantes=" + participantes +
                '}';
    }
}
