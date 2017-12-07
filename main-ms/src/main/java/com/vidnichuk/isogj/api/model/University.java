package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

/**
 * Created by Vadim on 07.11.2017.
 * University entity
 */
@Entity
@Table(name = "University")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of university
     */
    private String name;

    /**
     * city of locate university
     */
    @ManyToOne
    @JoinColumn(name = "City")
    private City city;

    /**
     *
     * @return
     * city of locate university
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * set city of locate university
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     * id of university
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set id of university
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * name of university
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * set name of university
     */
    public void setName(String name) {
        this.name = name;
    }
}
