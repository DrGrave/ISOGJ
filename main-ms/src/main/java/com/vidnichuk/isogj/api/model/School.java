package com.vidnichuk.isogj.api.model;

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
    private Long id;

    /**
     * city of school location
     */
    @ManyToOne
    @JoinColumn(name = "City")
    private City city;

    /**
     * name of school
     */
    private String name;

    /**
     *
     * @return
     * id of school
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set id of school
     */
    public void setId(Long id) {
        this.id = id;
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * set name of school
     */
    public void setName(String name) {
        this.name = name;
    }
}
