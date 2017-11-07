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

    @ManyToOne
        @JoinColumn(name = "City")
    private City city;

    @Column(name = "NameOfSchool")
    private String nameOfSchool;

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getNameOfSchool() {
        return nameOfSchool;
    }

    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }
}
