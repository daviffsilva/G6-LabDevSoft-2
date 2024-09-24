package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agente")
public class Agente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
}
