package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Vadim on 06.11.2017.
 * position of user in company
 */
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfPosition;

    /**
     * name of position in job
     */
    @Column(name = "NameOfPosition")
    private String nameOfPosition;

    /**
     *
     * @return
     * id of position
     */
    public int getIdOfPosition() {
        return idOfPosition;
    }

    /**
     *
     * @param idOfPosition
     * set id of position
     */
    public void setIdOfPosition(int idOfPosition) {
        this.idOfPosition = idOfPosition;
    }

    /**
     *
     * @return
     * name of position
     */
    public String getNameOfPosition() {
        return nameOfPosition;
    }

    /**
     *
     * @param nameOfPosition
     * set name of position
     */
    public void setNameOfPosition(String nameOfPosition) {
        this.nameOfPosition = nameOfPosition;
    }
}
