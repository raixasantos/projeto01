package com.imd0409.vacinacaobovino.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Vacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @ManyToMany(mappedBy = "vacinas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Fabricante> fabricantes = new ArrayList<Fabricante>();

    @Column(name = "periodoEmDias")
    private int periodoEmDias;

    @Column(name = "informacoesExtras", length = 150)
    private String informacoesExtras;

    @OneToMany(mappedBy = "vacina", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aplicacao> aplicacoes;
    
    public Vacina() {
    }

    public Vacina(String nome, int periodoEmDias, String informacoesExtras) {
        this.nome = nome;
        this.periodoEmDias = periodoEmDias;
        this.informacoesExtras = informacoesExtras;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Fabricante> getFabricantes() {
        return this.fabricantes;
    }

    public void addFabricante(Fabricante fabricante) {
        this.fabricantes.add(fabricante);
        fabricante.getVacinas().add(this);
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public int getPeriodoEmDias() {
        return this.periodoEmDias;
    }

    public void setPeriodoEmDias(int periodoEmDias) {
        this.periodoEmDias = periodoEmDias;
    }

    public String getInformacoesExtras() {
        return this.informacoesExtras;
    }

    public void setInformacoesExtras(String informacoesExtras) {
        this.informacoesExtras = informacoesExtras;
    }

    public List<Aplicacao> getAplicacoes() {
        return this.aplicacoes;
    }

    public void setAplicacoes(List<Aplicacao> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", fabricantes='" + getFabricantes() + "'" +
            ", periodoEmDias='" + getPeriodoEmDias() + "'" +
            ", informacoesExtras='" + getInformacoesExtras() + "'" +
            ", aplicacoes='" + getAplicacoes() + "'" +
            "}";
    }
}
