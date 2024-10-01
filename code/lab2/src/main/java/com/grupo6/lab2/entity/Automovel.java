package com.grupo6.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "automovel")
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "cor", nullable = false)
    private String cor;
}
