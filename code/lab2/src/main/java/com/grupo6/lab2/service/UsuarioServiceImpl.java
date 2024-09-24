package com.grupo6.lab2.service;

import com.google.common.hash.Hashing;
import com.grupo6.lab2.dto.request.UsuarioRequestDTO;
import com.grupo6.lab2.entity.Usuario;
import com.grupo6.lab2.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService{
    private final UsuarioRepository usuarioRepository;
    @Override
    public Optional<Usuario> register(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();
        String senha = usuarioRequestDTO.getSenha();
        String hashedSenha = Hashing.sha256()
                .hashString(senha, StandardCharsets.UTF_8)
                .toString();

        usuario.setLogin(usuarioRequestDTO.getUsuario());
        usuario.setLogin(hashedSenha);
        
        
        try {
            usuario = usuarioRepository.save(usuario);
            return Optional.of(usuario);
        }catch(Exception exception){
            return Optional.empty();
        }

    }
}
