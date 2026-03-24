package com.example.DecretandoViajesAPP.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "usuarios")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String names;
    private String email;
    private String password;
    private String role;

    public User() {
    }

    public User(UUID id, String names, String email, String password, String role) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
