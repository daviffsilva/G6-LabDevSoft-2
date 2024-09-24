package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.UsuarioRequestDTO;
import com.grupo6.lab2.entity.Usuario;

import java.util.Optional;

public interface IUsuarioService {

    Optional<Usuario> register(UsuarioRequestDTO usuarioRequestDTO);
}
