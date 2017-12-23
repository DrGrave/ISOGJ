package com.vidnichuk.isogj.api.dto.model;


import com.vidnichuk.isogj.api.model.Skill;

public class VacancySkillDto {
    private Long id;

    private Skill skill;

    private String expectedMark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getExpectedMark() {
        return expectedMark;
    }

    public void setExpectedMark(String expectedMark) {
        this.expectedMark = expectedMark;
    }
}
