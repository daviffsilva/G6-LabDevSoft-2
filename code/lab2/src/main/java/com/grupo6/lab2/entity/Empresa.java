package com.grupo6.lab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa extends Cliente{
    @Column(name = "cnpj")
    private String cnpj;
}
