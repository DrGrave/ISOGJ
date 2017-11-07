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

    /**
     * name of task
     */
    @Column(name = "NameOfTask")
    private String nameOfTask;

    /**
     * type of task
     */
    @ManyToOne
        @JoinColumn(name = "TypeOfTask")
    private TypeOfTask typeOfTask;

    /**
     * info of task
     */
    @Column(name = "InfoOfTask")
    private String infoOfTask;

    /**
     *
     * @return
     * id of task
     */
    public int getIdOfTask() {
        return idOfTask;
    }

    /**
     *
     * @return
     * type of task
     */
    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    /**
     *
     * @param typeOfTask
     * set type of task
     */
    public void setTypeOfTask(TypeOfTask typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    /**
     *
     * @param idOfTask
     * set id of task
     */
    public void setIdOfTask(int idOfTask) {
        this.idOfTask = idOfTask;
    }

    /**
     *
     * @return
     * name of task
     */
    public String getNameOfTask() {
        return nameOfTask;
    }

    /**
     *
     * @param nameOfTask
     * set name of task
     */
    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    /**
     *
     * @return
     * info of task
     */
    public String getInfoOfTask() {
        return infoOfTask;
    }

    /**
     *
     * @param infoOfTask
     * set info of task
     */
    public void setInfoOfTask(String infoOfTask) {
        this.infoOfTask = infoOfTask;
    }
}
