package com.vidnichuk.isogj.api.entity;

import com.vidnichuk.isogj.api.entity.type.TypeOfTask;

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
    private Long id;

    /**
     * name of task
     */
    private String name;

    /**
     * type of task
     */
    @ManyToOne
    @JoinColumn(name = "TypeOfTask")
    private TypeOfTask typeOfTask;

    /**
     * info of task
     */
    private String info;

    /**
     *
     * @return
     * id of task
     */
    public Long getId() {
        return id;
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
     * @param id
     * set id of task
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * name of task
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * set name of task
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * info of task
     */
    public String getInfo() {
        return info;
    }

    /**
     *
     * @param info
     * set info of task
     */
    public void setInfo(String info) {
        this.info = info;
    }
}
