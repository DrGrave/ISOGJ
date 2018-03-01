package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class TaskListDto {
    private VacancyTaskDto vacancyTaskDto;
    private List<TaskSkillDto> taskSkillDtoList;

    public TaskListDto(VacancyTaskDto vacancyTaskDto, List<TaskSkillDto> taskSkillDtoList) {
        this.vacancyTaskDto = vacancyTaskDto;
        this.taskSkillDtoList = taskSkillDtoList;
    }

    public TaskListDto() {
    }

    public VacancyTaskDto getVacancyTaskDto() {
        return vacancyTaskDto;
    }

    public void setVacancyTaskDto(VacancyTaskDto vacancyTaskDto) {
        this.vacancyTaskDto = vacancyTaskDto;
    }

    public List<TaskSkillDto> getTaskSkillDtoList() {
        return taskSkillDtoList;
    }

    public void setTaskSkillDtoList(List<TaskSkillDto> taskSkillDtoList) {
        this.taskSkillDtoList = taskSkillDtoList;
    }
}
