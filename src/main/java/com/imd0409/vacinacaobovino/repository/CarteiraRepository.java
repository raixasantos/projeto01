package com.imd0409.vacinacaobovino.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.model.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Integer> {

    @Query(value = "select * from carteira c where c.id_bovino like %:id% ",nativeQuery = true)
    Optional<Carteira> encontrarPorIdBovino(@Param("id") Integer id);

    Optional<Carteira> findByBovino(Bovino bovino);
}
