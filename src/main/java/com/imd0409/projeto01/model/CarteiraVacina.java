package com.imd0409.projeto01.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CarteiraVacina")
public class CarteiraVacina {
    @Id
    @Column(name = "idBovino")
    private Integer id;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "idBovino")
    private Bovino Bovino;

    @OneToMany(mappedBy = "CarteiraVacina")
    private Set<Aplicacao> aplicacoes;

    public CarteiraVacina() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bovino getBovino() {
        return this.Bovino;
    }

    public void setBovino(Bovino Bovino) {
        this.Bovino = Bovino;
    }

    public Set<Aplicacao> getAplicacoes() {
        return this.aplicacoes;
    }

    public void setAplicacoes(Set<Aplicacao> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", Bovino='" + getBovino() + "'" +
            ", aplicacoes='" + getAplicacoes() + "'" +
            "}";
    }
}
