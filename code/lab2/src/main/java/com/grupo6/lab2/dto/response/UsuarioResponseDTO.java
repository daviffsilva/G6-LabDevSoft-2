package com.grupo6.lab2.dto.response;

import com.grupo6.lab2.entity.Usuario;
import lombok.Getter;

@Getter
public class UsuarioResponseDTO {
    private Long id;
    private String usuario;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.usuario = usuario.getLogin();
    }
}
