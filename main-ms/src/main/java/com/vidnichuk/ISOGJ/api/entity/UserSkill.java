package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 02.11.2017.
 * Many to many class for user skills
 */
@Entity
@Table(name = "UserSkill")
public class UserSkill {

    /**
     *  id of many to many object
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserSkill;

    /**
     * id user to many to many object
     */
    @ManyToOne
        @JoinColumn(name = "idUser")
    private User idUser;

    /**
     * id skill to many to many object
     */
    @ManyToOne
        @JoinColumn(name = "idSkill")
    private Skill idSkill;

    @Column(name = "skillMark")
    private String skillMark;

    @Column(name = "skillPracticalMark")
    private String skillPracticalMark;


    /**
     *
     * @return
     * return skill mark
     */
    public String getSkillMark() {
        return skillMark;
    }

    /**
     *
     * @param skillMark
     * set skill mark
     */
    public void setSkillMark(String skillMark) {
        this.skillMark = skillMark;
    }

    /**
     *
     * @return
     * return skill practical mark
     */
    public String getSkillPracticalMark() {
        return skillPracticalMark;
    }

    /**
     *
     * @param skillPracticalMark
     * set skill of practical mark
     */
    public void setSkillPracticalMark(String skillPracticalMark) {
        this.skillPracticalMark = skillPracticalMark;
    }

    /**
     *
     * @return
     * return user object
     */
    public User getIdUser() {
        return idUser;
    }

    /**
     *
     * @param idUser
     * set user object to many to many object
     */
    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    /**
     *
     * @return
     * return skill object
     */
    public Skill getIdSkill() {
        return idSkill;
    }

    /**
     *
     * @param idSkill
     * set skill object to many to many
     */
    public void setIdSkill(Skill idSkill) {
        this.idSkill = idSkill;
    }
}
