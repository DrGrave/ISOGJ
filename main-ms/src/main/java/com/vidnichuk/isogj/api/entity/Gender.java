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
    private Long id;

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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        return id == gender.id && (nameOfGender != null ? nameOfGender.equals(gender.nameOfGender) : gender.nameOfGender == null);
    }
}
