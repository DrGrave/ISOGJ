package com.vidnichuk.ISOGJ.api.entity;

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
    private int idTypeOfSkill;

    /**
     * name of type
     */
    @Column(name = "NameOfTypeSkill")
    private String nameOfTypeSkill;

    /**
     *
     * @return
     * id of type
     */
    public int getIdTypeOfSkill() {
        return idTypeOfSkill;
    }

    /**
     *
     * @param idTypeOfSkill
     * set id of type
     */
    public void setIdTypeOfSkill(int idTypeOfSkill) {
        this.idTypeOfSkill = idTypeOfSkill;
    }

    /**
     *
     * @return
     * name of type
     */
    public String getNameOfTypeSkill() {
        return nameOfTypeSkill;
    }

    /**
     *
     * @param nameOfTypeSkill
     * set name of type
     */
    public void setNameOfTypeSkill(String nameOfTypeSkill) {
        this.nameOfTypeSkill = nameOfTypeSkill;
    }
}
