package com.grupo6.lab2.dto.request;

import lombok.Getter;

@Getter
public class EmpregoPessoaRequestDTO {
    private Long id;
    private String cnpj;
    private String nome;
    private double renda;
    private boolean rendaComprovada;
    private Long idPessoaFisica;
}
