package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * type of education entity
 */
@Entity
@Table(name = "TypeOfEducation")
public class TypeOfEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfEducation;
    
    @Column(name = "NameTypeOfEducation")
    private String nameTypeOfEducation;

    public int getIdTypeOfEducation() {
        return idTypeOfEducation;
    }

    public void setIdTypeOfEducation(int idTypeOfEducation) {
        this.idTypeOfEducation = idTypeOfEducation;
    }

    public String getNameTypeOfEducation() {
        return nameTypeOfEducation;
    }

    public void setNameTypeOfEducation(String nameTypeOfEducation) {
        this.nameTypeOfEducation = nameTypeOfEducation;
    }
}
