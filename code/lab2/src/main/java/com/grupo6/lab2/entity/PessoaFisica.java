package com.grupo6.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

// Talvez um Id proprio para pessoa fisica ao inves de ser uma entidade fraca
@Entity
@Table(name = "pessoa_fisica")
@Getter
public class PessoaFisica extends Cliente{
    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "profissao")
    private String profissao;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = EmpregoPessoa.class, cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<EmpregoPessoa> empregosPessoa;

    @Id
    @PrimaryKeyJoinColumn(name = "id_cliente", referencedColumnName = "id", columnDefinition = "id_cliente")
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

}
