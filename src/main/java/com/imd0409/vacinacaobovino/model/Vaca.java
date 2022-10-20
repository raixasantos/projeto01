package com.imd0409.vacinacaobovino.model;

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
@Table(name = "Vaca")
public class Vaca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "producaoLeite")
    private float producaoLeite;

    @Column(name = "darLeite")
    private boolean darLeite;

    @Column(name = "gravida")
    private boolean gravida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBovino", referencedColumnName = "id")
    private Bovino bovino;

    public Vaca() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getProducaoLeite() {
        return this.producaoLeite;
    }

    public void setProducaoLeite(float producaoLeite) {
        this.producaoLeite = producaoLeite;
    }

    public boolean isDarLeite() {
        return this.darLeite;
    }

    public boolean getDarLeite() {
        return this.darLeite;
    }

    public void setDarLeite(boolean darLeite) {
        this.darLeite = darLeite;
    }

    public boolean isGravida() {
        return this.gravida;
    }

    public boolean getGravida() {
        return this.gravida;
    }

    public void setGravida(boolean gravida) {
        this.gravida = gravida;
    }

    public Bovino getBovino() {
        return this.bovino;
    }

    public void setBovino(Bovino bovino) {
        this.bovino = bovino;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", producaoLeite='" + getProducaoLeite() + "'" +
            ", darLeite='" + isDarLeite() + "'" +
            ", gravida='" + isGravida() + "'" +
            ", bovino='" + getBovino() + "'" +
            "}";
    }
}
