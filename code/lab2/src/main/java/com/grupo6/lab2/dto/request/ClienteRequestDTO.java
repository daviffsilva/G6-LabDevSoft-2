package com.grupo6.lab2.dto.request;

import lombok.Getter;

@Getter
public class ClienteRequestDTO {

    private String id;

    private UsuarioRequestDTO usuario;
    private PessoaFisicaRequestDTO pessoaFisica;
    private EmpresaRequestDTO empresa;
    private String nome;
}
