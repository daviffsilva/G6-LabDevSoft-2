
package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.AutomovelRequestDTO;
import com.grupo6.lab2.dto.response.AutomovelResponseDTO;
import com.grupo6.lab2.entity.Automovel;
import com.grupo6.lab2.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutomovelServiceImpl implements IAutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    @Override
    public Optional<AutomovelResponseDTO> register(AutomovelRequestDTO automovelRequestDTO) {
        Automovel automovel = new Automovel();
        automovel.setMarca(automovelRequestDTO.getMarca());
        automovel.setModelo(automovelRequestDTO.getModelo());
        automovel.setAno(automovelRequestDTO.getAno());
        automovel.setPlaca(automovelRequestDTO.getPlaca());
        automovel.setCor(automovelRequestDTO.getCor());
        Automovel savedAutomovel = automovelRepository.save(automovel);
        return Optional.of(new AutomovelResponseDTO(savedAutomovel.getId(), savedAutomovel.getMarca(), savedAutomovel.getModelo(), savedAutomovel.getAno(), savedAutomovel.getPlaca(), savedAutomovel.getCor()));
    }

    @Override
    public Optional<AutomovelResponseDTO> updateAutomovel(Long id, AutomovelRequestDTO automovelRequestDTO) {
        Optional<Automovel> optionalAutomovel = automovelRepository.findById(id);
        if (optionalAutomovel.isPresent()) {
            Automovel automovel = optionalAutomovel.get();
            automovel.setMarca(automovelRequestDTO.getMarca());
            automovel.setModelo(automovelRequestDTO.getModelo());
            automovel.setAno(automovelRequestDTO.getAno());
            automovel.setPlaca(automovelRequestDTO.getPlaca());
            automovel.setCor(automovelRequestDTO.getCor());
            Automovel updatedAutomovel = automovelRepository.save(automovel);
            return Optional.of(new AutomovelResponseDTO(updatedAutomovel.getId(), updatedAutomovel.getMarca(), updatedAutomovel.getModelo(), updatedAutomovel.getAno(), updatedAutomovel.getPlaca(), updatedAutomovel.getCor()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteAutomovel(Long id) {
        if (automovelRepository.existsById(id)) {
            automovelRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<AutomovelResponseDTO> getAllAutomoveis() {
        return automovelRepository.findAll().stream()
                .map(automovel -> new AutomovelResponseDTO(automovel.getId(), automovel.getMarca(), automovel.getModelo(), automovel.getAno(), automovel.getPlaca(), automovel.getCor()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AutomovelResponseDTO> getAutomovelById(Long id) {
        Optional<Automovel> automovel = automovelRepository.findById(id);
        return automovel.map(value -> new AutomovelResponseDTO(value.getId(), value.getMarca(), value.getModelo(), value.getAno(), value.getPlaca(), value.getCor()));
    }
}
