package com.grupo6.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "status_aluguel")
@Getter
public enum StatusAluguel {
    ABERTO(1L, "ABERTO" ),
    EM_AVALIACAO(2L, "EM_AVALIACAO"),
    APROVADO(3L, "APROVADO"),
    FECHADO(4L, "FECHADO"),
    REPROVADO(5L, "REPROVADO");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    StatusAluguel(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static StatusAluguel getById(Long id) {
        for (StatusAluguel status : StatusAluguel.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        return null;
    }
}
