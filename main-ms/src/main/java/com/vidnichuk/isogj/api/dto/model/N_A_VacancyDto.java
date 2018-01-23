package com.vidnichuk.isogj.api.dto.model;

/**
 * vacancy dto object
 */
public class N_A_VacancyDto {
    private Long id;
    private String info;
    private String typeOfVacancy;
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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

    public String getTypeOfVacancy() {
        return typeOfVacancy;
    }

    public void setTypeOfVacancy(String typeOfVacancy) {
        this.typeOfVacancy = typeOfVacancy;
    }
}
