package com.vidnichuk.ISOGJ.api.entity;


import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * entity to city
 */
@Entity
@Table(name = "City")
public class City {

    /**
     * id of city
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCity;


    /**
     * name of city
     */
    @Column(name = "NameOfCity")
    private String nameOfCity;

    /**
     *
     * @return
     * id of city
     */
    public int getIdCity() {
        return idCity;
    }

    /**
     *
     * @param idCity
     * set id of city
     */
    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    /**
     *
     * @return
     * name of city
     */
    public String getNameOfCity() {
        return nameOfCity;
    }

    /**
     *
     * @param nameOfCity
     * set name of city
     */
    public void setNameOfCity(String nameOfCity) {
        this.nameOfCity = nameOfCity;
    }
}
