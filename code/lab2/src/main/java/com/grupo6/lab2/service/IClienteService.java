package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.ClienteRequestDTO;
import com.grupo6.lab2.entity.Cliente;

import java.util.Optional;

public interface IClienteService {
    Optional<Cliente> register(ClienteRequestDTO clienteRequestDTO);
}
