package com.grupo6.lab2.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovelRequestDTO {
    private String modelo;
    private String marca;
    private Integer ano;
    private String placa;
    private String cor;
}

