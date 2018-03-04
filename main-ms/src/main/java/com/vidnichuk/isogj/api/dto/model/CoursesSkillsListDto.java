package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class CoursesSkillsListDto {
    private UserCoursesDto userCoursesDto;
    private List<CoursesSkillDto> coursesSkillDtoList;

    public CoursesSkillsListDto(UserCoursesDto userCoursesDto, List<CoursesSkillDto> coursesSkillDtoList) {
        this.userCoursesDto = userCoursesDto;
        this.coursesSkillDtoList = coursesSkillDtoList;
    }

    public CoursesSkillsListDto() {
    }

    public UserCoursesDto getUserCoursesDto() {
        return userCoursesDto;
    }

    public void setUserCoursesDto(UserCoursesDto userCoursesDto) {
        this.userCoursesDto = userCoursesDto;
    }

    public List<CoursesSkillDto> getCoursesSkillDtoList() {
        return coursesSkillDtoList;
    }

    public void setCoursesSkillDtoList(List<CoursesSkillDto> coursesSkillDtoList) {
        this.coursesSkillDtoList = coursesSkillDtoList;
    }
}
