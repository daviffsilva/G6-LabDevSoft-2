package com.grupo6.lab2.controller;


import com.grupo6.lab2.dto.request.ClienteRequestDTO;
import com.grupo6.lab2.dto.response.ClienteResponseDTO;
import com.grupo6.lab2.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/cliente")
@RequiredArgsConstructor
@CrossOrigin
public class ClienteController {
    private final IClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> register(@RequestBody ClienteRequestDTO clienteRequestDTO, UriComponentsBuilder uriBuilder){
        clienteService.register(clienteRequestDTO);

        return ResponseEntity.ok().body(new ClienteResponseDTO());
    }
}
