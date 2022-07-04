package com.ricardo.tareas_proyectos_jpa.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long uid;

    @Column
    public String nombre;

    @Column
    public String email;

    @Column
    public String password;

    //	@Transient
    @Column
    public String foto;

    public Usuario() {
    }


    public Usuario(Long uid, String nombre, String email, String password, String foto) {
        this.uid = uid;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.foto = foto;
    }

    public Usuario(String nombre, String email, String password, String foto) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.foto = foto;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public String getPassword() {
        this.password = null;
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void actualizarPropiedadsPublicas(Usuario u) {
        if (u.getNombre() != null) {
            setNombre(u.getNombre());
        }
        if (u.getEmail() != null) {
            setEmail(u.getEmail());
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "uid=" + uid +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
