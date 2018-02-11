package com.vidnichuk.isogj.api.dto.model;

public class UserFullCompanyDto {
    private Long idUserCompany;
    private FullCompanyDto company;
    private PositionDto position;

    public Long getIdUserCompany() {
        return idUserCompany;
    }

    public void setIdUserCompany(Long idUserCompany) {
        this.idUserCompany = idUserCompany;
    }

    public FullCompanyDto getCompany() {
        return company;
    }

    public void setCompany(FullCompanyDto company) {
        this.company = company;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }
}
