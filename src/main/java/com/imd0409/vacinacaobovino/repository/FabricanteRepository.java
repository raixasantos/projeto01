package com.imd0409.vacinacaobovino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imd0409.vacinacaobovino.model.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    List<Fabricante> findFabricantesByVacinasId(Integer idVacina);
}
