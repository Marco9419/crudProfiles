package com.swift.model;

import jakarta.persistence.*;

@Entity
@Table(name="profiles")
public class ProfilesModel {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String nombre;

    @Column(name="users")
    private String usuario;

    @Column(name = "profile")
    private String perfil;

    public ProfilesModel(Long id, String nombre, String usuario, String perfil) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.perfil = perfil;
    }

    public ProfilesModel() {}

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
