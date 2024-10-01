package com.grupo6.lab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empresa")
@Getter
@Setter
public class Empresa extends Cliente{
    @Column(name = "cnpj")
    private String cnpj;
}
