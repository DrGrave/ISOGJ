package com.vidnichuk.isogj.api.dto.model;

public class DepartmentSkillDto {
    private Long id;
    private DepartmentDto department;
    private SkillDto skill;
    private int mark;

    public Long getId() {
        return id;
    }

    public DepartmentSkillDto(Long id, DepartmentDto department, SkillDto skill, int mark) {
        this.id = id;
        this.department = department;
        this.skill = skill;
        this.mark = mark;
    }

    public DepartmentSkillDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
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
