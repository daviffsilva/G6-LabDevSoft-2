package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.ClienteRequestDTO;
import com.grupo6.lab2.dto.response.ClienteResponseDTO;
import java.util.List;
import java.util.Optional;

public interface IClienteService {
    Optional<ClienteResponseDTO> register(ClienteRequestDTO clienteRequestDTO);
    Optional<ClienteResponseDTO> getClienteById(Long id);
    Optional<ClienteResponseDTO> updateCliente(Long id, ClienteRequestDTO clienteRequestDTO);
    boolean deleteCliente(Long id);
    List<ClienteResponseDTO> getAllClientes();
}
