package com.vidnichuk.isogj.api.dto.model;

public class SkillDto {
    private Long id;
    private String name;
    private TypeOfSkillDto typeOfSkill;

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

    public TypeOfSkillDto getTypeOfSkill() {
        return typeOfSkill;
    }

    public void setTypeOfSkill(TypeOfSkillDto typeOfSkill) {
        this.typeOfSkill = typeOfSkill;
    }
}
