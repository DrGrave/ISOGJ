package com.vidnichuk.isogj.api.dto;

/**
 * vacancy dto object
 */
public class VacancyDTO {
    private int idVacancy;
    private String infoOfVacancy;
    private String typeOfVacancy;

    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public String getInfoOfVacancy() {
        return infoOfVacancy;
    }

    public void setInfoOfVacancy(String infoOfVacancy) {
        this.infoOfVacancy = infoOfVacancy;
    }

    public String getTypeOfVacancy() {
        return typeOfVacancy;
    }

    public void setTypeOfVacancy(String typeOfVacancy) {
        this.typeOfVacancy = typeOfVacancy;
    }
}
