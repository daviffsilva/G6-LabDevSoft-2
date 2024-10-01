package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.AluguelRequestDTO;
import com.grupo6.lab2.entity.Aluguel;

import java.util.List;

public interface IAluguelService {
    List<Aluguel> getAllAlugueis();
    Aluguel getAluguelById(Long id);
    Aluguel createAluguel(AluguelRequestDTO aluguelRequestDTO);
    Aluguel updateAluguel(Long id, AluguelRequestDTO aluguelRequestDTO);
    boolean deleteAluguel(Long id);
}