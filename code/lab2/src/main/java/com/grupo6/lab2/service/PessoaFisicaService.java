package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.PessoaFisicaRequestDTO;
import com.grupo6.lab2.entity.PessoaFisica;
import com.grupo6.lab2.repository.PessoaFisicaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class PessoaFisicaService implements IPessoaFisicaService{
    private final PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public Optional<PessoaFisica> register(PessoaFisicaRequestDTO pessoaFisicaRequestDTO) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setRg(pessoaFisicaRequestDTO.getRg());
        pessoaFisica.setCpf(pessoaFisicaRequestDTO.getCpf());
        pessoaFisica.setEndereco(pessoaFisicaRequestDTO.getEndereco());
        pessoaFisica.setProfissao(pessoaFisicaRequestDTO.getProfissao());
        PessoaFisica savedPessoaFisica = pessoaFisicaRepository.save(pessoaFisica);
        
        return Optional.of(savedPessoaFisica);
    }

    @Override
    public Optional<PessoaFisica> getPessoaFisicaById(Long id) {
        return pessoaFisicaRepository.findById(id);
    }

    @Override
    public Optional<PessoaFisica> updatePessoaFisica(Long id, PessoaFisicaRequestDTO pessoaFisicaRequestDTO) {
        Optional<PessoaFisica> existingPessoaFisica = pessoaFisicaRepository.findById(id);
        if (existingPessoaFisica.isPresent()) {
            PessoaFisica pessoaFisica = existingPessoaFisica.get();
            pessoaFisica.setNome(pessoaFisicaRequestDTO.getNome());
            pessoaFisica.setCpf(pessoaFisicaRequestDTO.getCpf());
            pessoaFisica.setEndereco(pessoaFisicaRequestDTO.getEndereco());
            pessoaFisica.setProfissao(pessoaFisicaRequestDTO.getProfissao());
            pessoaFisicaRepository.save(pessoaFisica);
            return Optional.of(pessoaFisica);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deletePessoaFisica(Long id) {
        if (pessoaFisicaRepository.existsById(id)) {
            pessoaFisicaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
