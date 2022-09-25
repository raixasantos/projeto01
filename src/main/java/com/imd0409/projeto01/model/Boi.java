package com.imd0409.projeto01.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Boi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reprodutor")
    private Boolean reprodutor;

    @Column(name = "castrado")
    private Boolean castrado;


    public Boi() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
            ", reprodutor='" + isReprodutor() + "'" +
            ", castrado='" + isCastrado() + "'" +
            "}";
    }

}
