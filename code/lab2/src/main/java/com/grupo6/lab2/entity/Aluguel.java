package com.grupo6.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aluguel")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public void setClienteById(Long clienteId) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        this.cliente = cliente;
    }

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @JoinColumn(name = "id_automovel", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Automovel automovel;

    @JoinColumn(name = "status_aluguel", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusAluguel statusAluguel;

    @JoinColumn(name = "id_contrato_credito", referencedColumnName = "id", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private ContratoCredito contratoCredito;
    

    @Column(name = "duracao_contrato", nullable = false)
    private Integer duracaoContrato;

    @JoinColumn(name = "id_aprovador", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agente aprovador;



    public void setAutomovelById(Long automovelId) {
        Automovel automovel = new Automovel();
        automovel.setId(automovelId);
        this.automovel = automovel;
    }

    public void setStatusAluguelById(Long statusAluguelId) {
        StatusAluguel statusAluguel = StatusAluguel.getById(statusAluguelId);
        this.statusAluguel = statusAluguel;
    }

    public void setContratoCreditoById(Long contratoCreditoId) {
        ContratoCredito contratoCredito = new ContratoCredito();
        contratoCredito.setId(contratoCreditoId);
        this.contratoCredito = contratoCredito;
    }

    public void setAprovadorById(Long aprovadorId) {
        Agente aprovador = new Agente();
        aprovador.setId(aprovadorId);
        this.aprovador = aprovador;
    }
}
