package com.imd0409.vacinacaobovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imd0409.vacinacaobovino.model.Vaca;

public interface VacaRepository extends JpaRepository<Vaca, Integer> {
    
}
