package com.imd0409.projeto01.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Boi")
public class Boi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBovino", referencedColumnName = "id")
    private Bovino bovino;

    @Column(name = "reprodutor")
    private Boolean reprodutor;

    @Column(name = "castrado")
    private Boolean castrado;

    public Boi() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bovino getBovino() {
        return this.bovino;
    }

    public void setBovino(Bovino bovino) {
        this.bovino = bovino;
    }

    public Boolean isReprodutor() {
        return this.reprodutor;
    }

    public Boolean getReprodutor() {
        return this.reprodutor;
    }

    public void setReprodutor(Boolean reprodutor) {
        this.reprodutor = reprodutor;
    }

    public Boolean isCastrado() {
        return this.castrado;
    }

    public Boolean getCastrado() {
        return this.castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", bovino='" + getBovino() + "'" +
            ", reprodutor='" + isReprodutor() + "'" +
            ", castrado='" + isCastrado() + "'" +
            "}";
    }
}
