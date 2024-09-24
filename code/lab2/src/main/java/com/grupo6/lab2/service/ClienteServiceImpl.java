package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.ClienteRequestDTO;
import com.grupo6.lab2.entity.Cliente;
import com.grupo6.lab2.entity.Empresa;
import com.grupo6.lab2.entity.PessoaFisica;
import com.grupo6.lab2.entity.Usuario;
import com.grupo6.lab2.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService{
    private final ClienteRepository clienteRepository;
    private final IPessoaFisicaService pessoaFisicaService;
    private final IEmpresaService empresaService;
    private final IUsuarioService usuarioService;

    @Override
    public Optional<Cliente> register(ClienteRequestDTO clienteRequestDTO) throws IllegalArgumentException {
        if(clienteRequestDTO.getEmpresa() != null && clienteRequestDTO.getPessoaFisica() != null){
            throw new IllegalArgumentException("Cliente informado não pode ser Empresa e Pessoa Física ao mesmo tempo!");
        }else if(clienteRequestDTO.getEmpresa() == null && clienteRequestDTO.getPessoaFisica() == null){
            throw new IllegalArgumentException("Cliente informado deve ser Empresa ou Pessoa Física!");
        }

        if(clienteRequestDTO.getId() != null){
            return clienteRepository.findById(Long.valueOf(clienteRequestDTO.getId()));
        }

        Usuario usuarioCadastrado = usuarioService.register(clienteRequestDTO.getUsuario()).orElse(null);
        Cliente cliente = new Cliente();
        cliente.setUsuario(usuarioCadastrado);
        cliente.setNome(clienteRequestDTO.getNome());
        clienteRepository.save(cliente);

        PessoaFisica pessoaFisica;
        Empresa empresa;

        if(clienteRequestDTO.getPessoaFisica() != null){
            clienteRequestDTO.getPessoaFisica().setId(cliente.getId());
            pessoaFisica = pessoaFisicaService.register(clienteRequestDTO.getPessoaFisica()).orElse(null);
        }else if(clienteRequestDTO.getEmpresa() != null){
            clienteRequestDTO.getEmpresa().setId(cliente.getId());
            empresa = empresaService.register(clienteRequestDTO.getEmpresa()).orElse(null);
        }

        return Optional.empty();
    }
}
