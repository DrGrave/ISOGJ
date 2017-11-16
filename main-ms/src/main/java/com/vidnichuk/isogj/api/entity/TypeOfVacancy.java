package com.vidnichuk.isogj.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * type of vacancy entity
 */
@Entity
@Table(name = "TypeOfVacancy")
public class TypeOfVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfVacancy;

    /**
     * name of type of vacancy
     */
    @Column(name = "NameTypeOfVacancy")
    private String nameTypeOfVacancy;

    /**
     *
     * @return
     * id type of vacancy
     */
    public int getIdTypeOfVacancy() {
        return idTypeOfVacancy;
    }

    /**
     *
     * @param idTypeOfVacancy
     * set id type of vacancy
     */
    public void setIdTypeOfVacancy(int idTypeOfVacancy) {
        this.idTypeOfVacancy = idTypeOfVacancy;
    }

    /**
     *
     * @return
     * name type of vacancy
     */
    public String getNameTypeOfVacancy() {
        return nameTypeOfVacancy;
    }

    /**
     *
     * @param nameTypeOfVacancy
     * set name type of vacancy
     */
    public void setNameTypeOfVacancy(String nameTypeOfVacancy) {
        this.nameTypeOfVacancy = nameTypeOfVacancy;
    }

}
