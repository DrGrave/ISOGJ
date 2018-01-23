package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.Company;
import com.vidnichuk.isogj.api.model.Position;

public class UserCompanyDto {
    private Long idUserCompany;
    private CompanyDto company;
    private PositionDto position;

    public Long getIdUserCompany() {
        return idUserCompany;
    }

    public void setIdUserCompany(Long idUserCompany) {
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
