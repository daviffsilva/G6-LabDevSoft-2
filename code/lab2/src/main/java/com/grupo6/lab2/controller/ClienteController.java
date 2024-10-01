package com.grupo6.lab2.controller;


import com.grupo6.lab2.dto.request.ClienteRequestDTO;
import com.grupo6.lab2.dto.response.ClienteResponseDTO;
import com.grupo6.lab2.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente")
@RequiredArgsConstructor
@CrossOrigin
public class ClienteController {
    private final IClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> register(@RequestBody ClienteRequestDTO clienteRequestDTO, UriComponentsBuilder uriBuilder){
        ClienteResponseDTO clienteResponseDTO = clienteService.register(clienteRequestDTO).orElse(null);

        if(clienteResponseDTO != null){
            return ResponseEntity.ok().body(clienteResponseDTO);
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable Long id) {
        Optional<ClienteResponseDTO> clienteResponseDTO = clienteService.getClienteById(id);
        return clienteResponseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        Optional<ClienteResponseDTO> updatedCliente = clienteService.updateCliente(id, clienteRequestDTO);
        return updatedCliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        boolean isDeleted = clienteService.deleteCliente(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAllClientes() {
        List<ClienteResponseDTO> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }
}
