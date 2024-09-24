package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.EmpresaRequestDTO;
import com.grupo6.lab2.entity.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class EmpresaServiceImpl implements IEmpresaService{
    @Override
    public Optional<Empresa> register(EmpresaRequestDTO empresaRequestDTO) {
        return Optional.empty();
    }
}
