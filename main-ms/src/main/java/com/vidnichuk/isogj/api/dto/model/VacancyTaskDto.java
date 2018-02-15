package com.vidnichuk.isogj.api.dto.model;

public class VacancyTaskDto {

    private Long id;
    private TaskDto task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskDto getTask() {
        return task;
    }

    public void setTask(TaskDto task) {
        this.task = task;
    }
}
