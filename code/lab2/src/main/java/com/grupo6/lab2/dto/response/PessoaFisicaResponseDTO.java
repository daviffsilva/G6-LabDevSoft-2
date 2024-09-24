package com.grupo6.lab2.dto.response;

import com.grupo6.lab2.entity.PessoaFisica;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PessoaFisicaResponseDTO {
    private Long id;
    private String rg;
    private String cpf;
    private String endereco;
    private String profissao;
    private List<EmpregoPessoaResponseDTO> listEmpregoPessoa;

    public PessoaFisicaResponseDTO(PessoaFisica pessoaFisica){
        this.id = pessoaFisica.getId();
        this.rg = pessoaFisica.getRg();
        this.cpf = pessoaFisica.getRg();
        this.endereco = pessoaFisica.getEndereco();
        this.profissao = pessoaFisica.getProfissao();
    }
}
