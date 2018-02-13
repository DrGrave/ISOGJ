package com.vidnichuk.isogj.api.dto.model;

/**
 * vacancy dto object
 */
public class N_A_VacancyDto {
    private Long id;
    private String info;
    private TypeOfVacancyDto typeOfVacancy;
    private CompanyDto companyName;


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

    public void setCompanyName(CompanyDto companyName) {
        this.companyName = companyName;
    }

    public CompanyDto getCompanyName() {
        return companyName;
    }
}
