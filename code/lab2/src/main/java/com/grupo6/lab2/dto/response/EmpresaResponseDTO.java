package com.grupo6.lab2.dto.response;

import com.grupo6.lab2.entity.Empresa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaResponseDTO {
    private Long id;
    private String cnpj;

    public EmpresaResponseDTO(Empresa empresa){

    }
}
