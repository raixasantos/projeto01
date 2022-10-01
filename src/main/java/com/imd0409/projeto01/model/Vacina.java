package com.imd0409.projeto01.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Vacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @ManyToMany
    private List<Fabricante> fabricantes;

    @Column(name = "periodoEmDias")
    private int periodoEmDias;

    @Column(name = "quantidadeDeMls")
    private float quantidadeDeMls;

    @Column(name = "informacoesExtras", length = 150)
    private String informacoesExtras;

    @OneToMany(mappedBy = "vacina", fetch = FetchType.LAZY)
    private List<Aplicacao> aplicacoes;
    
    public Vacina() {
    }
}
