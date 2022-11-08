package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.rest.dto.BovinoDTO;

@Service
public interface BovinoService {

    public Integer adicionarBovino(BovinoDTO bovinoDTO);
    public List<Bovino> obterListaBovino();
    public Optional<Bovino> obterBovinoPorId(Integer id);
    public void editarPeso(Integer id, Float novoNome);
    public void editarChifre(Integer id, Boolean novoChifre);
    public void apagarBovino(Integer id);
}
