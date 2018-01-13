package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.Company;
import com.vidnichuk.isogj.api.model.Position;

public class UserCompanyDto {
    private Long idUserCompany;
    private Company company;
    private Position position;

    public Long getIdUserCompany() {
        return idUserCompany;
    }

    public void setIdUserCompany(Long idUserCompany) {
        this.idUserCompany = idUserCompany;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
