package com.grupo6.lab2.dto.response;

import com.grupo6.lab2.entity.Cliente;
import com.grupo6.lab2.entity.PessoaFisica;

public class ClienteResponseDTO {

    private Long id;

    private UsuarioResponseDTO usuario;
    private PessoaFisicaResponseDTO pessoaFisica;
    private EmpresaResponseDTO empresa;
    private String nome;

    public ClienteResponseDTO(Cliente cliente){
        this.id = cliente.getId();
        this.usuario = new UsuarioResponseDTO(cliente.getUsuario());
    }

    public ClienteResponseDTO(Cliente cliente, PessoaFisica pessoaFisica){
        this(cliente);
        this.nome = cliente.getNome();
        this.pessoaFisica = new PessoaFisicaResponseDTO(pessoaFisica);
    }
}
