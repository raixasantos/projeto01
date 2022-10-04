package com.imd0409.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Bovino;

@Service
public interface BovinoService {

    public void salvarBovino(Bovino bovino);
    public List<Bovino> getListaBovino();
    public void apagarBovino(Integer id);
    public void editarBovino(Bovino bovino);
    public Optional<Bovino> getBovinoById(Integer id);
}
