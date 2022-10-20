package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.model.Carteira;

@Service
public interface CarteiraService {
    
    public List<Carteira> getListaCarteira();
    public Carteira salvarCarteira(Bovino bovino);
    public Optional<Carteira> getCarteiraByIdBovino(Integer id);
    
}
