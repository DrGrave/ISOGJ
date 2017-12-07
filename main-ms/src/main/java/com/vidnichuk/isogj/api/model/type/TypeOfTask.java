package com.vidnichuk.isogj.api.model.type;

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
    private Long id;

    /**
     * name of type of task
     */
    @Column
    private String name;

    /**
     * @return id of type of task
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of type task
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name of type of task
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name of type of task
     */
    public void setName(String name) {
        this.name = name;
    }
}
