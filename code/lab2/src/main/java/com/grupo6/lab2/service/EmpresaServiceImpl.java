package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.EmpresaRequestDTO;
import com.grupo6.lab2.entity.Empresa;
import com.grupo6.lab2.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class EmpresaServiceImpl implements IEmpresaService{
    private final EmpresaRepository empresaRepository;
    
    @Override
    public Optional<Empresa> register(EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = new Empresa();
        empresa.setNome(empresaRequestDTO.getNome());
        empresa.setCnpj(empresaRequestDTO.getCnpj());
        Empresa savedEmpresa = empresaRepository.save(empresa);
        
        return Optional.of(savedEmpresa);
    }

    @Override
    public Optional<Empresa> getEmpresaById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Optional<Empresa> updateEmpresa(Long id, EmpresaRequestDTO empresaRequestDTO) {
        Optional<Empresa> existingEmpresa = empresaRepository.findById(id);
        if (existingEmpresa.isPresent()) {
            Empresa empresa = existingEmpresa.get();
            empresa.setNome(empresaRequestDTO.getNome());
            empresa.setCnpj(empresaRequestDTO.getCnpj());
            empresaRepository.save(empresa);
            return Optional.of(empresa);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteEmpresa(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
