package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agente_bancario")
public class AgenteBancario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
}
