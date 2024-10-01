package com.grupo6.lab2.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AluguelResponseDTO {
    private Long id;
    private Long clienteId;
    private Long automovelId;
    private Long statusAluguelId;
    private Long contratoCreditoId;
    private Integer duracaoContrato;
    private Long aprovadorId;
}