package com.grupo6.lab2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Cliente {
    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "profissao")
    private String profissao;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = EmpregoPessoa.class, cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<EmpregoPessoa> empregosPessoa;
}
