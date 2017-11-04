package com.vidnichuk.ISOGJ.api.entity;

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
    private int idSkill;

    /**
     * name of skill
     */
    @Column(name = "NameOfSkill", nullable = false)
    private String nameOfSkill;

    /**
     * type of skill
     */
    @ManyToOne
        @JoinColumn(name = "TypeOfSkill", nullable = false)
    private TypeOfSkill typeOfSkill;

    /**
     *
     * @return
     * type of skill
     */
    public TypeOfSkill getTypeOfSkill() {
        return typeOfSkill;
    }

    /**
     *
     * @param typeOfSkill
     * set type of skill
     */
    public void setTypeOfSkill(TypeOfSkill typeOfSkill) {
        this.typeOfSkill = typeOfSkill;
    }

    /**
     *
     * @return
     * return id of skill
     */
    public int getIdSkill() {
        return idSkill;
    }

    /**
     *
     * @param idSkill
     * get id of skill
     */
    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    /**
     *
     * @return
     * return name of skill
     */
    public String getNameOfSkill() {
        return nameOfSkill;
    }

    /**
     *
     * @param nameOfSkill
     * set name of skill to object
     */
    public void setNameOfSkill(String nameOfSkill) {
        this.nameOfSkill = nameOfSkill;
    }
}
