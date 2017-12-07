package com.vidnichuk.isogj.api.model.type;

import javax.persistence.*;

/**
 * Created by Vadim on 03.11.2017.
 * type of skill
 */
@Entity
@Table(name = "TypeOfSkill")
public class TypeOfSkill {

    /**
     * id of type
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of type
     */
    private String name;

    /**
     * @return id of type
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of type
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name of type
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name of type
     */
    public void setName(String name) {
        this.name = name;
    }
}
