package com.example.DecretandoViajesAPP.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "espacios")

public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String names;
    private String descripcion;
    private String foto;
    private Integer aforo;

    public Space() {
    }

    public Space(UUID id, String descripcion, String foto, Integer aforo) {
        this.id = id;
        this.names = names;
        this.descripcion = descripcion;
        this.foto = foto;
        this.aforo = aforo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public String setNames(String names) {return names;}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }
}
