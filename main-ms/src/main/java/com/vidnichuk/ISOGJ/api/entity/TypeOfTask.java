package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * type of task entity
 */
@Entity
@Table(name = "TypeOfTask")
public class TypeOfTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfTask;

    /**
     * name of type of task
     */
    @Column
    private String nameTypeOfTask;

    /**
     *
     * @return
     * id of type of task
     */
    public int getIdTypeOfTask() {
        return idTypeOfTask;
    }

    /**
     *
     * @param idTypeOfTask
     * set id of type task
     */
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
