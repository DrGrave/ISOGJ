package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class EducationSkillsDto {
    private EducationDto educationDto;
    private List<DepartmentSkillDto> departmentSkillDtoList;

    public EducationSkillsDto(EducationDto educationDto, List<DepartmentSkillDto> departmentSkillDtoList) {
        this.educationDto = educationDto;
        this.departmentSkillDtoList = departmentSkillDtoList;
    }

    public EducationSkillsDto() {
    }

    public EducationDto getEducationDto() {
        return educationDto;
    }

    public void setEducationDto(EducationDto educationDto) {
        this.educationDto = educationDto;
    }

    public List<DepartmentSkillDto> getDepartmentSkillDtoList() {
        return departmentSkillDtoList;
    }

    public void setDepartmentSkillDtoList(List<DepartmentSkillDto> departmentSkillDtoList) {
        this.departmentSkillDtoList = departmentSkillDtoList;
    }
}
