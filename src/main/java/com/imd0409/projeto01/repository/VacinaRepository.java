package com.imd0409.projeto01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imd0409.projeto01.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Integer> {
    // adicionar no fabricante_vacina
}
