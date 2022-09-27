package com.imd0409.projeto01.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CarteiraVacina")
public class CarteiraVacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "idAnimal")
    private Integer idAnimal;

    private List<Vacina> vacinas;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAnimal() {
        return this.idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public List<Vacina> getVacinas() {
        return this.vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idAnimal='" + getIdAnimal() + "'" +
            ", vacinas='" + getVacinas() + "'" +
            "}";
    }
}
