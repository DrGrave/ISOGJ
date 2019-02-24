package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

/**
 * class for many to many subject skill
 */
@Entity
@Table(name = "SubjectSkill")
public class SubjectSkill {

    /**
     * id of subjectskill entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * subject entity
     */
    @ManyToOne
    @JoinColumn(name = "Subject", nullable = false)
    private Subject subject;

    /**
     * skill entity
     */
    @ManyToOne
    @JoinColumn(name = "Skill", nullable = false)
    private Skill skill;

    /**
     * percent witch this skill consider width subject
     */
    private int percentOfSubject;

    /**
     * percent witch this skill have influence at all education
     */
    private int percentOfSkill;

    /**
     * getter for percent of subject
     * @return percent of subject
     */
    public int getPercentOfSubject() {
        return percentOfSubject;
    }

    /**
     * setter for percent of subject
     * @param percentOfSubject field
     */
    public void setPercentOfSubject(int percentOfSubject) {
        this.percentOfSubject = percentOfSubject;
    }

    /**
     * getter for percent of skill
     * @return percent of skill
     */
    public int getPercentOfSkill() {
        return percentOfSkill;
    }

    /**
     * setter for percent of skill
     * @param percentOfSkill field
     */
    public void setPercentOfSkill(int percentOfSkill) {
        this.percentOfSkill = percentOfSkill;
    }

    /**
     * getter for id
     * @return id of subject
     */
    public long getId() {
        return id;
    }

    /**
     * setter for id
     * @param id of subject skill
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getter for subject
     * @return subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * setter for subject
     * @param subject entity
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * getter for skill
     * @return skill
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     * setter for skill
     * @param skill entity
     */
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
