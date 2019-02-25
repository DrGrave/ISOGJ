package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class EducationSkillsDto {
    private EducationDto educationDto;

    public EducationSkillsDto(EducationDto educationDto) {
        this.educationDto = educationDto;
    }

    public EducationSkillsDto() {
    }

    public EducationDto getEducationDto() {
        return educationDto;
    }

    public void setEducationDto(EducationDto educationDto) {
        this.educationDto = educationDto;
    }


}
