package com.vidnichuk.isogj.api.dto.model;



public class HistorySkillsDto {
    private HistoryDto historyDto;
    private CoursesSkillsListDto coursesSkillDto;
    private ExperienceSkillsDto experienceSkillsDto;
    private EducationSkillsDto educationSkillsDto;


    public HistorySkillsDto(HistoryDto historyDto, CoursesSkillsListDto coursesSkillDto, ExperienceSkillsDto experienceSkillsDto, EducationSkillsDto educationSkillsDto) {
        this.historyDto = historyDto;
        this.coursesSkillDto = coursesSkillDto;
        this.experienceSkillsDto = experienceSkillsDto;
        this.educationSkillsDto = educationSkillsDto;
    }

    public HistorySkillsDto() {
    }

    public HistoryDto getHistoryDto() {
        return historyDto;
    }

    public void setHistoryDto(HistoryDto historyDto) {
        this.historyDto = historyDto;
    }

    public CoursesSkillsListDto getCoursesSkillDto() {
        return coursesSkillDto;
    }

    public void setCoursesSkillDto(CoursesSkillsListDto coursesSkillDto) {
        this.coursesSkillDto = coursesSkillDto;
    }

    public ExperienceSkillsDto getExperienceSkillsDto() {
        return experienceSkillsDto;
    }

    public void setExperienceSkillsDto(ExperienceSkillsDto experienceSkillsDto) {
        this.experienceSkillsDto = experienceSkillsDto;
    }

    public EducationSkillsDto getEducationSkillsDto() {
        return educationSkillsDto;
    }

    public void setEducationSkillsDto(EducationSkillsDto educationSkillsDto) {
        this.educationSkillsDto = educationSkillsDto;
    }
}
