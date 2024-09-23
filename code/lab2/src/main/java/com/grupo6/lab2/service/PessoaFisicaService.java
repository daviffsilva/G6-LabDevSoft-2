package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.PessoaFisicaRequestDTO;
import com.grupo6.lab2.entity.PessoaFisica;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class PessoaFisicaService implements IPessoaFisicaService{
    @Override
    public Optional<PessoaFisica> register(PessoaFisicaRequestDTO pessoaFisicaRequestDTO) {
        return Optional.empty();
    }
}
