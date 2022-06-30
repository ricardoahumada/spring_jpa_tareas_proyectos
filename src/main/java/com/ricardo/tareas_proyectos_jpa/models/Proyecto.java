package com.ricardo.tareas_proyectos_jpa.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "project")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long pid;

    @Column
    public String titulo;

    @Column
    public Date fecha_inicio;

    @Column
    public Date fecha_fin;

    @ManyToOne
    @JoinColumn(name = "responsable", nullable = false)
    public Usuario responsable;

    @ManyToMany
    @JoinTable(
            name = "project_tasks",
            joinColumns = @JoinColumn(name = "project", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "task", nullable = false)
    )
    private Set<Tarea> tareas;

    public Proyecto() {
    }

    public Proyecto(Long pid, String titulo, Date fecha_inicio, Date fecha_fin, Usuario responsable) {
        this.pid = pid;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.responsable = responsable;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "pid=" + pid +
                ", titulo='" + titulo + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", responsable=" + responsable +
                ", tareas=" + tareas +
                '}';
    }
}
