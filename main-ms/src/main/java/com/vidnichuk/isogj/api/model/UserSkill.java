package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

/**
 * Created by Vadim on 02.11.2017.
 * Many to many class for user skills
 */
@Entity
@Table(name = "UserSkill")
public class UserSkill {

    /**
     * id of many to many object
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * id user to many to many object
     */
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    /**
     * object of person who set the mark
     */
    @ManyToOne
    @JoinColumn(name = "idMarker")
    private User marker;

    /**
     * id skill to many to many object
     */
    @ManyToOne
    @JoinColumn(name = "idSkill")
    private Skill skill;

    /**
     * mark of theoretical skill
     */
    private String skillMark;

    /**
     * mark of practical skill
     */
    private String skillPracticalMark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user who set the mark
     */
    public User getMarker() {
        return marker;
    }

    /**
     * @param marker set user who set the mark
     */
    public void setMarker(User marker) {
        this.marker = marker;
    }

    /**
     * @return return skill mark
     */
    public String getSkillMark() {
        return skillMark;
    }

    /**
     * @param skillMark set skill mark
     */
    public void setSkillMark(String skillMark) {
        this.skillMark = skillMark;
    }

    /**
     * @return return skill practical mark
     */
    public String getSkillPracticalMark() {
        return skillPracticalMark;
    }

    /**
     * @param skillPracticalMark set skill of practical mark
     */
    public void setSkillPracticalMark(String skillPracticalMark) {
        this.skillPracticalMark = skillPracticalMark;
    }

    /**
     * @return return user object
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user set user object to many to many object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return return skill object
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     * @param skill set skill object to many to many
     */
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
