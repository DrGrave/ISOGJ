package com.vidnichuk.isogj.api.dto.model;

public class TaskSkillDto {
    private Long id;
    private SkillDto skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }
}
