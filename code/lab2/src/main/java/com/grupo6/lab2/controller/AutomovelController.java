package com.grupo6.lab2.controller;

import com.grupo6.lab2.dto.request.AutomovelRequestDTO;
import com.grupo6.lab2.dto.response.AutomovelResponseDTO;
import com.grupo6.lab2.service.IAutomovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automovel")
@RequiredArgsConstructor
public class AutomovelController {
    private final IAutomovelService automovelService;

    @PostMapping
    public ResponseEntity<AutomovelResponseDTO> createAutomovel(@RequestBody AutomovelRequestDTO automovelRequestDTO) {
        Optional<AutomovelResponseDTO> automovelResponseDTO = automovelService.register(automovelRequestDTO);
        return automovelResponseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutomovelResponseDTO> updateAutomovel(@PathVariable Long id, @RequestBody AutomovelRequestDTO automovelRequestDTO) {
        Optional<AutomovelResponseDTO> automovelResponseDTO = automovelService.updateAutomovel(id, automovelRequestDTO);
        return automovelResponseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutomovel(@PathVariable Long id) {
        boolean deleted = automovelService.deleteAutomovel(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AutomovelResponseDTO>> getAllAutomoveis() {
        List<AutomovelResponseDTO> automoveis = automovelService.getAllAutomoveis();
        return ResponseEntity.ok(automoveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutomovelResponseDTO> getAutomovelById(@PathVariable Long id) {
        Optional<AutomovelResponseDTO> automovelResponseDTO = automovelService.getAutomovelById(id);
        return automovelResponseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
