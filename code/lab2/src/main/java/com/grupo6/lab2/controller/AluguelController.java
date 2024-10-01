package com.grupo6.lab2.controller;

import com.grupo6.lab2.dto.request.AluguelRequestDTO;
import com.grupo6.lab2.dto.response.AluguelResponseDTO;
import com.grupo6.lab2.entity.Aluguel;
import com.grupo6.lab2.service.IAluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private IAluguelService aluguelService;

    @GetMapping
    public List<AluguelResponseDTO> getAllAlugueis() {
        return aluguelService.getAllAlugueis().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelResponseDTO> getAluguelById(@PathVariable Long id) {
        AluguelResponseDTO aluguel = convertToResponseDTO(aluguelService.getAluguelById(id));
        if (aluguel != null) {
            return ResponseEntity.ok(aluguel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AluguelResponseDTO createAluguel(@RequestBody AluguelRequestDTO aluguelRequestDTO) {
        return convertToResponseDTO(aluguelService.createAluguel(aluguelRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AluguelResponseDTO> updateAluguel(@PathVariable Long id, @RequestBody AluguelRequestDTO aluguelRequestDTO) {
        AluguelResponseDTO updatedAluguel = convertToResponseDTO(aluguelService.updateAluguel(id, aluguelRequestDTO));
        if (updatedAluguel != null) {
            return ResponseEntity.ok(updatedAluguel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(@PathVariable Long id) {
        boolean isDeleted = aluguelService.deleteAluguel(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private AluguelResponseDTO convertToResponseDTO(Aluguel aluguel) {
        AluguelResponseDTO responseDTO = new AluguelResponseDTO();
        responseDTO.setId(aluguel.getId());
        responseDTO.setClienteId(aluguel.getCliente().getId());
        responseDTO.setAutomovelId(aluguel.getAutomovel().getId());
        responseDTO.setStatusAluguelId(aluguel.getStatusAluguel().getId());
        responseDTO.setContratoCreditoId(aluguel.getContratoCredito().getId());
        responseDTO.setDuracaoContrato(aluguel.getDuracaoContrato());
        responseDTO.setAprovadorId(aluguel.getAprovador().getId());
        return responseDTO;
    }
}
