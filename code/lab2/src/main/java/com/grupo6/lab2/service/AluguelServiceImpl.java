package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.AluguelRequestDTO;
import com.grupo6.lab2.entity.Aluguel;
import com.grupo6.lab2.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelServiceImpl implements IAluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public List<Aluguel> getAllAlugueis() {
        return aluguelRepository.findAll();
    }

    @Override
    public Aluguel getAluguelById(Long id) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        return aluguel.orElse(null);
    }

    @Override
    public Aluguel createAluguel(AluguelRequestDTO aluguelRequestDTO) {
        Aluguel aluguel = new Aluguel();
        aluguel.setClienteById(aluguelRequestDTO.getClienteId());
        aluguel.setAutomovelById(aluguelRequestDTO.getAutomovelId());
        aluguel.setStatusAluguelById(aluguelRequestDTO.getStatusAluguelId());
        aluguel.setContratoCreditoById(aluguelRequestDTO.getContratoCreditoId());
        aluguel.setDuracaoContrato(aluguelRequestDTO.getDuracaoContrato());
        aluguel.setAprovadorById(aluguelRequestDTO.getAprovadorId());
        return aluguelRepository.save(aluguel);
    }

    @Override
    public Aluguel updateAluguel(Long id, AluguelRequestDTO aluguelRequestDTO) {
        Optional<Aluguel> optionalAluguel = aluguelRepository.findById(id);
        if (optionalAluguel.isPresent()) {
            Aluguel aluguel = optionalAluguel.get();
            aluguel.setClienteById(aluguelRequestDTO.getClienteId());
            aluguel.setAutomovelById(aluguelRequestDTO.getAutomovelId());
            aluguel.setStatusAluguelById(aluguelRequestDTO.getStatusAluguelId());
            aluguel.setContratoCreditoById(aluguelRequestDTO.getContratoCreditoId());
            aluguel.setDuracaoContrato(aluguelRequestDTO.getDuracaoContrato());
            aluguel.setAprovadorById(aluguelRequestDTO.getAprovadorId());
            return aluguelRepository.save(aluguel);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAluguel(Long id) {
        if (aluguelRepository.existsById(id)) {
            aluguelRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
