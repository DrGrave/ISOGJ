package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class ExperienceSkillsDto {
    private ExperienceDto experienceDto;
    private List<PositionSkillDto> positionSkillDtoList;

    public ExperienceSkillsDto(ExperienceDto experienceDto, List<PositionSkillDto> positionSkillDtoList) {
        this.experienceDto = experienceDto;
        this.positionSkillDtoList = positionSkillDtoList;
    }

    public ExperienceSkillsDto() {
    }

    public ExperienceDto getExperienceDto() {
        return experienceDto;
    }

    public void setExperienceDto(ExperienceDto experienceDto) {
        this.experienceDto = experienceDto;
    }

    public List<PositionSkillDto> getPositionSkillDtoList() {
        return positionSkillDtoList;
    }

    public void setPositionSkillDtoList(List<PositionSkillDto> positionSkillDtoList) {
        this.positionSkillDtoList = positionSkillDtoList;
    }
}
