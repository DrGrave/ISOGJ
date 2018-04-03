package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class SkillsToPositionDto {
    private String name;
    private List<SkillDto> skills;
    private PositionDto position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }
}
