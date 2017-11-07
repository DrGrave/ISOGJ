package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * entity of task
 */
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfTask;

    @Column(name = "NameOfTask")
    private String nameOfTask;

    @Column(name = "InfoOfTask")
    private String infoOfTask;

    public int getIdOfTask() {
        return idOfTask;
    }

    public void setIdOfTask(int idOfTask) {
        this.idOfTask = idOfTask;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public String getInfoOfTask() {
        return infoOfTask;
    }

    public void setInfoOfTask(String infoOfTask) {
        this.infoOfTask = infoOfTask;
    }
}
