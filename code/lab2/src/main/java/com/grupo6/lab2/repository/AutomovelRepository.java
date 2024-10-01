package com.grupo6.lab2.repository;

import com.grupo6.lab2.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}
