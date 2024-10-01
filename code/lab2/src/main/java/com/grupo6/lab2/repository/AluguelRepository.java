package com.grupo6.lab2.repository;

import com.grupo6.lab2.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
