package com.imd0409.vacinacaobovino.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.imd0409.vacinacaobovino.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
}
