package com.vidnichuk.isogj.api.dto.model;

import java.util.Date;

public class FullCompanyDto extends CompanyDto{
    private String info;
    private Date dateOfCreation;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
