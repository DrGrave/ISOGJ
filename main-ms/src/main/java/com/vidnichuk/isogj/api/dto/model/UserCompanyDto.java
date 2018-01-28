package com.vidnichuk.isogj.api.dto.model;


public class UserCompanyDto {
    private int idUserCompany;
    private CompanyDto company;
    private PositionDto position;

    public int getIdUserCompany() {
        return idUserCompany;
    }

    public void setIdUserCompany(int idUserCompany) {
        this.idUserCompany = idUserCompany;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }
}
