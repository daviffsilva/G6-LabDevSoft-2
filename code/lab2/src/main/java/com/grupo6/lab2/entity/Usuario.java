package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;
}
