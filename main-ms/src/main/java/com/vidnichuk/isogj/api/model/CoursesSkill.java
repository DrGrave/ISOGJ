package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

@Entity
@Table(name = "CoursesSkill")
public class CoursesSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Courses")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "Skill")
    private Skill skill;

    @Column(name = "Mark")
    private int mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
