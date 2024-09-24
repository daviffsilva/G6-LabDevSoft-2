package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contrato_credito")
public class ContratoCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
}
