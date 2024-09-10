package com.grupo6.lab2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public abstract class Cliente extends Usuario{

}
