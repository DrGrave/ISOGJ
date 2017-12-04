package com.vidnichuk.isogj.api.entity.type;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * type of vacancy entity
 */
@Entity
@Table(name = "TypeOfVacancy")
public class TypeOfVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of type of vacancy
     */
    private String name;

    /**
     *
     * @return
     * id type of vacancy
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set id type of vacancy
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * name type of vacancy
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * set name type of vacancy
     */
    public void setName(String name) {
        this.name = name;
    }

}
