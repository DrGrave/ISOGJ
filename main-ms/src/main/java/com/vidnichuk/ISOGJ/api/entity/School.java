package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * school entity
 */
@Entity
@Table(name = "School")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchool;

    /**
     * city of school location
     */
    @ManyToOne
        @JoinColumn(name = "City")
    private City city;

    /**
     * name of school
     */
    @Column(name = "NameOfSchool")
    private String nameOfSchool;

    /**
     *
     * @return
     * id of school
     */
    public int getIdSchool() {
        return idSchool;
    }

    /**
     *
     * @param idSchool
     * set id of school
     */
    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    /**
     *
     * @return
     * city of school location
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * set city of location
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     * name of school
     */
    public String getNameOfSchool() {
        return nameOfSchool;
    }

    /**
     *
     * @param nameOfSchool
     * set name of school
     */
    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }
}
