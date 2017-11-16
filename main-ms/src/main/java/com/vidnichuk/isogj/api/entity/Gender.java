package com.vidnichuk.isogj.api.entity;

import javax.persistence.*;

/**
 * Created by vadim on 16.10.17.
 * gender of user
 */
@Entity
@Table(name="Gender")
public class Gender {

    /**
     * id of gender
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGender;

    /**
     * name of gender
     */

    @Column(name = "NameOdGender", nullable = false)
    private String nameOfGender;

    /**
     *
     * @return
     * gender id
     */
    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    /**
     *
     * @return
     * name of gender
     */
    public String getNameOfGender() {
        return nameOfGender;
    }

    public void setNameOfGender(String nameOfGender) {
        this.nameOfGender = nameOfGender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        return idGender == gender.idGender && (nameOfGender != null ? nameOfGender.equals(gender.nameOfGender) : gender.nameOfGender == null);
    }

    @Override
    public int hashCode() {
        int result = idGender;
        result = 31 * result + (nameOfGender != null ? nameOfGender.hashCode() : 0);
        return result;
    }
}
