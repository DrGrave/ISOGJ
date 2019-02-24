package com.vidnichuk.isogj.api.model;


import javax.persistence.*;

/**
 * entity for mark to subject skill
 */
@Entity
@Table(name = "SubjectSkillUser")
public class SubjectSkillUser {

    /**
     * id Subject user skill
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * subject skill entity
     */
    @ManyToOne
    @JoinColumn(name = "SubjectSkill", nullable = false)
    private SubjectSkill subjectSkill;

    /**
     *  user entity
     */
    @ManyToOne
    @JoinColumn(name = "User", nullable = false)
    private User user;

    /**
     * mark for subject skill
     */
    private int mark;

    /**
     * expert who set mark
     */
    @ManyToOne
    @JoinColumn(name = "Expert", nullable = false)
    private User expert;


    /**
     * getter for mark
     * @return mark
     */
    public int getMark() {
        return mark;
    }

    /**
     * setter for mark
     * @param mark field
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * getter for expert
     * @return expert
     */
    public User getExpert() {
        return expert;
    }

    /**
     * setter for expert
     * @param expert entity
     */
    public void setExpert(User expert) {
        this.expert = expert;
    }

    /**
     * getter for id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * setter for id
     * @param id field
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getter for subject skill
     * @return subject skill
     */
    public SubjectSkill getSubjectSkill() {
        return subjectSkill;
    }

    /**
     * setter for subject skill
     * @param subjectSkill entity
     */
    public void setSubjectSkill(SubjectSkill subjectSkill) {
        this.subjectSkill = subjectSkill;
    }

    /**
     * getter for user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * setter for user
     * @param user entity
     */
    public void setUser(User user) {
        this.user = user;
    }
}
