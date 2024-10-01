package com.grupo6.lab2.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovelResponseDTO {
    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private String placa;
    private String cor;

    public AutomovelResponseDTO() {
    }

    public AutomovelResponseDTO(Long id, String marca, String modelo, Integer ano, String placa, String cor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.cor = cor;
    }
}

