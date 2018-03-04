package com.vidnichuk.isogj.api.dto.model;


public class CoursesSkillDto {
    private Long id;
    private CoursesDto courses;
    private SkillDto skill;
    private int mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoursesDto getCourses() {
        return courses;
    }

    public void setCourses(CoursesDto courses) {
        this.courses = courses;
    }

    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
