package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.rest.dto.BovinoDTO;

@Service
public interface BovinoService {

    public Bovino salvarBovino(BovinoDTO bovinoDTO);
    public List<Bovino> getListaBovino();
    public void apagarBovino(Integer id);
    public void editarBovino(Bovino bovino);
    public void atualizarPeso(Integer id, Float novoNome);
    public Optional<Bovino> getBovinoById(Integer id);
}
