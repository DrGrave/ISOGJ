package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Vadim on 06.11.2017.
 * type of task entity
 */
public class TypeOfTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfTask;

    /**
     * name of type of task
     */
    @Column
    private String nameTypeOfTask;

    public int getIdTypeOfTask() {
        return idTypeOfTask;
    }

    public void setIdTypeOfTask(int idTypeOfTask) {
        this.idTypeOfTask = idTypeOfTask;
    }

    /**
     *
     * @return
     * name of type of task
     */
    public String getNameTypeOfTask() {
        return nameTypeOfTask;
    }

    /**
     *
     * @param nameTypeOfTask
     * set name of type of task
     */
    public void setNameTypeOfTask(String nameTypeOfTask) {
        this.nameTypeOfTask = nameTypeOfTask;
    }
}
