package com.vidnichuk.isogj.api.dto.model;

public class VacancyDto {
    private Long id;
    private String info;
    private TypeOfVacancyDto typeOfVacancy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public TypeOfVacancyDto getTypeOfVacancy() {
        return typeOfVacancy;
    }

    public void setTypeOfVacancy(TypeOfVacancyDto typeOfVacancy) {
        this.typeOfVacancy = typeOfVacancy;
    }

}
