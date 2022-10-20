package com.imd0409.vacinacaobovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imd0409.vacinacaobovino.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Integer> {
    // adicionar no fabricante_vacina
}
