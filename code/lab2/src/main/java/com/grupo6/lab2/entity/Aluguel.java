package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aluguel")
public class Aluguel {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @JoinColumn(name = "id_automovel", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Automovel automovel;

    @JoinColumn(name = "status_aluguel", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusAluguel statusAluguel;
}
