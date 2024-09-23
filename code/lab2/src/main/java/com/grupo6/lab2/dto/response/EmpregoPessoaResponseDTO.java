package com.grupo6.lab2.dto.response;

import lombok.Getter;

@Getter
public class EmpregoPessoaResponseDTO {
    private Long id;
    private String cnpj;
    private String nome;
    private double renda;
    private boolean rendaComprovada;
    private Long idPessoaFisica;
}
