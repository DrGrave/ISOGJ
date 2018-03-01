package com.vidnichuk.isogj.api.dto.model;


public class UserCompanyDto {
    private Long idUserCompany;
    private CompanyDto company;
    private PositionDto position;
    private Boolean companyApprove;
    private Boolean changeApprove;

    public Boolean getCompanyApprove() {
        return companyApprove;
    }

    public void setCompanyApprove(Boolean companyApprove) {
        this.companyApprove = companyApprove;
    }

    public Boolean getChangeApprove() {
        return changeApprove;
    }

    public void setChangeApprove(Boolean changeApprove) {
        this.changeApprove = changeApprove;
    }

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
