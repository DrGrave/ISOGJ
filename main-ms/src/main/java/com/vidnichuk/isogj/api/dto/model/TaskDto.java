package com.vidnichuk.isogj.api.dto.model;

public class TaskDto {
    private Long id;
    private String name;
    private TypeOfTaskDto typeOfTask;
    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfTaskDto getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(TypeOfTaskDto typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
