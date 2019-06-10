package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class EducationSkillsDto {
    private EducationDto educationDto;
    private List<SubjectSkillUserDto> userSkillDtos;


    public EducationSkillsDto(EducationDto educationDto, List<SubjectSkillUserDto> userSkillDtos) {
        this.educationDto = educationDto;
        this.userSkillDtos = userSkillDtos;
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
