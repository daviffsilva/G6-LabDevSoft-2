package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.PessoaFisicaRequestDTO;
import com.grupo6.lab2.entity.PessoaFisica;

import java.util.Optional;

public interface IPessoaFisicaService {
    Optional<PessoaFisica> register(PessoaFisicaRequestDTO pessoaFisicaRequestDTO);
}
