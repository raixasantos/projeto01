package com.imd0409.projeto01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imd0409.projeto01.model.AplicacaoKey;

public interface AplicacaoKeyRepository extends JpaRepository<AplicacaoKey, Integer> {
    
}
