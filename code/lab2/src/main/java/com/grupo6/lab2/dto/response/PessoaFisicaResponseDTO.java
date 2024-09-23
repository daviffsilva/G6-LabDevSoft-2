package com.grupo6.lab2.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PessoaFisicaResponseDTO {
    private Long id;
    private String rg;
    private String cpf;
    private String nome;
    private String endereco;
    private String profissao;
    private List<EmpregoPessoaResponseDTO> listEmpregoPessoa;
}
