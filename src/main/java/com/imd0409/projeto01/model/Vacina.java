package com.imd0409.projeto01.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "fabricante", length = 50)
    private String fabricante;

    @Column(name = "periodoEmDias")
    private int periodoEmDias;

    @Column(name = "quantidadeDeMls")
    private float quantidadeDeMls;

    @Column(name = "informacoesExtras", length = 150)
    private String informacoesExtras;


}
