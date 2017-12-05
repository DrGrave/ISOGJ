package com.vidnichuk.isogj.api.entity.type;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * type of education entity
 */
@Entity
@Table(name = "TypeOfEducation")
public class TypeOfEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of type education
     */
    private String name;

    /**
     *
     * @return
     * id of type education
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set id type of education
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * name of type of education
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * set name of type education
     */
    public void setName(String name) {
        this.name = name;
    }
}
