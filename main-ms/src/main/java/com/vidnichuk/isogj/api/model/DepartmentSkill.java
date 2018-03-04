package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

@Entity
@Table(name = "DepartmentSkill")
public class DepartmentSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Department")
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
