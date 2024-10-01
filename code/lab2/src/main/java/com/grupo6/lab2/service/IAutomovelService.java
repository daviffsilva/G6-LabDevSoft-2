package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.AutomovelRequestDTO;
import com.grupo6.lab2.dto.response.AutomovelResponseDTO;
import java.util.List;
import java.util.Optional;

public interface IAutomovelService {
    Optional<AutomovelResponseDTO> register(AutomovelRequestDTO automovelRequestDTO);
    Optional<AutomovelResponseDTO> updateAutomovel(Long id, AutomovelRequestDTO automovelRequestDTO);
    boolean deleteAutomovel(Long id);
    List<AutomovelResponseDTO> getAllAutomoveis();
    Optional<AutomovelResponseDTO> getAutomovelById(Long id);
}
