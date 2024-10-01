package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.ClienteRequestDTO;
import com.grupo6.lab2.dto.response.ClienteResponseDTO;
import com.grupo6.lab2.entity.Cliente;
import com.grupo6.lab2.entity.Empresa;
import com.grupo6.lab2.entity.PessoaFisica;
import com.grupo6.lab2.entity.Usuario;
import com.grupo6.lab2.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService{
    private final ClienteRepository clienteRepository;
    private final IPessoaFisicaService pessoaFisicaService;
    private final IEmpresaService empresaService;
    private final IUsuarioService usuarioService;

    @Override
    public Optional<ClienteResponseDTO> register(ClienteRequestDTO clienteRequestDTO) throws IllegalArgumentException {
        if(clienteRequestDTO.getEmpresa() != null && clienteRequestDTO.getPessoaFisica() != null){
            throw new IllegalArgumentException("Cliente informado não pode ser Empresa e Pessoa Física ao mesmo tempo!");
        }else if(clienteRequestDTO.getEmpresa() == null && clienteRequestDTO.getPessoaFisica() == null){
            throw new IllegalArgumentException("Cliente informado deve ser Empresa ou Pessoa Física!");
        }

        if(clienteRequestDTO.getId() != null){
            return Optional.of(new ClienteResponseDTO(clienteRepository.findById(Long.valueOf(clienteRequestDTO.getId())).orElse(null)));
        }

        Usuario usuarioCadastrado = usuarioService.register(clienteRequestDTO.getUsuario()).orElse(null);
        Cliente cliente = new Cliente();
        cliente.setUsuario(usuarioCadastrado);
        cliente.setNome(clienteRequestDTO.getNome());
        clienteRepository.save(cliente);

        PessoaFisica pessoaFisica;
        Empresa empresa;

        ClienteResponseDTO clienteResponseDTO = null;

        if(clienteRequestDTO.getPessoaFisica() != null){
            clienteRequestDTO.getPessoaFisica().setId(cliente.getId());
            pessoaFisica = pessoaFisicaService.register(clienteRequestDTO.getPessoaFisica()).orElse(null);
            clienteResponseDTO = new ClienteResponseDTO(cliente, pessoaFisica);
        }else if(clienteRequestDTO.getEmpresa() != null){
            clienteRequestDTO.getEmpresa().setId(cliente.getId());
            empresa = empresaService.register(clienteRequestDTO.getEmpresa()).orElse(null);
            clienteResponseDTO = new ClienteResponseDTO(cliente, empresa);
        }


        return Optional.of(clienteResponseDTO);
    }

    @Override
    public Optional<ClienteResponseDTO> getClienteById(Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    PessoaFisica pessoaFisica = pessoaFisicaService.getPessoaFisicaById(id).orElse(null);
                    Empresa empresa = empresaService.getEmpresaById(id).orElse(null);
                    if(pessoaFisica == null){
                        return new ClienteResponseDTO(cliente, empresa);
                    }else{
                        return new ClienteResponseDTO(cliente, pessoaFisica);
                    }
                });
    }

    @Override
    public Optional<ClienteResponseDTO> updateCliente(Long id, ClienteRequestDTO clienteRequestDTO) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteRequestDTO.getNome());
                    clienteRepository.save(cliente);

                    if (clienteRequestDTO.getPessoaFisica() != null) {
                        clienteRequestDTO.getPessoaFisica().setId(id);
                        pessoaFisicaService.updatePessoaFisica(id, clienteRequestDTO.getPessoaFisica());
                    } else if (clienteRequestDTO.getEmpresa() != null) {
                        clienteRequestDTO.getEmpresa().setId(id);
                        empresaService.updateEmpresa(id, clienteRequestDTO.getEmpresa());
                    }

                    PessoaFisica pessoaFisica = pessoaFisicaService.getPessoaFisicaById(id).orElse(null);
                    Empresa empresa = empresaService.getEmpresaById(id).orElse(null);
                    if(pessoaFisica == null){
                        return new ClienteResponseDTO(cliente, empresa);
                    }else{
                        return new ClienteResponseDTO(cliente, pessoaFisica);
                    }
                });
    }

    @Override
    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            pessoaFisicaService.deletePessoaFisica(id);
            empresaService.deleteEmpresa(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ClienteResponseDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> {
                    PessoaFisica pessoaFisica = pessoaFisicaService.getPessoaFisicaById(cliente.getId()).orElse(null);
                    Empresa empresa = empresaService.getEmpresaById(cliente.getId()).orElse(null);
                    if(pessoaFisica == null){
                        return new ClienteResponseDTO(cliente, empresa);
                    }else{
                        return new ClienteResponseDTO(cliente, pessoaFisica);
                    }
                })
                .collect(Collectors.toList());
    }
}
