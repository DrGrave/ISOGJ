package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Vadim on 06.11.2017.
 * type of vacancy entity
 */
public class TypeOfVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfVacancy;

    /**
     * name of type of vacancy
     */
    @Column(name = "NameTypeOfVacancy")
    private int nameTypeOfVacancy;

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
    public int getNameTypeOfVacancy() {
        return nameTypeOfVacancy;
    }

    /**
     *
     * @param nameTypeOfVacancy
     * set name type of vacancy
     */
    public void setNameTypeOfVacancy(int nameTypeOfVacancy) {
        this.nameTypeOfVacancy = nameTypeOfVacancy;
    }

}
