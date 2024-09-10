package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "status_aluguel")
public enum StatusAluguel {
    ABERTO(),
    EM_AVALIACAO(),
    APROVADO(),
    FECHADO(),
    REPROVADO();

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
}
