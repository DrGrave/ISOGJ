package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class VacancyListDto {
    private VacancyDto vacancy;
    private List<VacancySkillDto> skillDtoList;
    private List<TaskListDto> taskListDtoList;

    public VacancyListDto(VacancyDto vacancy, List<VacancySkillDto> skillDtoList, List<TaskListDto> taskListDtoList) {
        this.vacancy = vacancy;
        this.skillDtoList = skillDtoList;
        this.taskListDtoList = taskListDtoList;
    }

    public VacancyListDto() {
    }

    public VacancyDto getVacancy() {
        return vacancy;
    }

    public void setVacancy(VacancyDto vacancy) {
        this.vacancy = vacancy;
    }

    public List<VacancySkillDto> getSkillDtoList() {
        return skillDtoList;
    }

    public void setSkillDtoList(List<VacancySkillDto> skillDtoList) {
        this.skillDtoList = skillDtoList;
    }

    public List<TaskListDto> getTaskListDtoList() {
        return taskListDtoList;
    }

    public void setTaskListDtoList(List<TaskListDto> taskListDtoList) {
        this.taskListDtoList = taskListDtoList;
    }
}
