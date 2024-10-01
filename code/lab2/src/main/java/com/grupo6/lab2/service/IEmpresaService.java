package com.grupo6.lab2.service;

import com.grupo6.lab2.dto.request.EmpresaRequestDTO;
import com.grupo6.lab2.entity.Empresa;

import java.util.Optional;

public interface IEmpresaService {
    Optional<Empresa> register(EmpresaRequestDTO empresaRequestDTO);
    Optional<Empresa> getEmpresaById(Long id);
    Optional<Empresa> updateEmpresa(Long id, EmpresaRequestDTO empresaRequestDTO);
    boolean deleteEmpresa(Long id);
}
