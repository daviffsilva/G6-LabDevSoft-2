package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "automovel")
public class Automovel {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
}
