package com.grupo6.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emprego_pessoa")
public class EmpregoPessoa {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome")
    private String nome;

    @Column(name = "renda")
    private double renda;

    @Column(name = "renda_comprovada")
    private boolean rendaComprovada;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private PessoaFisica pessoa;
}
