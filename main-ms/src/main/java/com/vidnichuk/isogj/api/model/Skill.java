package com.vidnichuk.isogj.api.model;

import com.vidnichuk.isogj.api.model.type.TypeOfSkill;

import javax.persistence.*;

/**
 * Created by Vadim on 02.11.2017.
 * class to skills to user
 */

@Entity
@Table(name = "Skill")
public class Skill {

    /**
     * id of skill
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of skill
     */
    private String name;

    /**
     * type of skill
     */
    @ManyToOne
    @JoinColumn(name = "TypeOfSkill", nullable = false)
    private TypeOfSkill typeOfSkill;

    /**
     * @return type of skill
     */
    public TypeOfSkill getTypeOfSkill() {
        return typeOfSkill;
    }

    /**
     * @param typeOfSkill set type of skill
     */
    public void setTypeOfSkill(TypeOfSkill typeOfSkill) {
        this.typeOfSkill = typeOfSkill;
    }

    /**
     * @return return id of skill
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id get id of skill
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return return name of skill
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name of skill to object
     */
    public void setName(String name) {
        this.name = name;
    }
}
