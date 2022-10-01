package com.imd0409.projeto01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imd0409.projeto01.model.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Integer> {
    
}
