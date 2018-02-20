package com.vidnichuk.isogj.api.dto.model;

public class UserFullCompanyDto {
    private Long idUserCompany;
    private FullCompanyDto company;
    private PositionDto position;
    private boolean companyApprove;
    private boolean changeApprove;

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

    public boolean isCompanyApprove() {
        return companyApprove;
    }

    public void setCompanyApprove(boolean companyApprove) {
        this.companyApprove = companyApprove;
    }

    public boolean isChangeApprove() {
        return changeApprove;
    }

    public void setChangeApprove(boolean changeApprove) {
        this.changeApprove = changeApprove;
    }
}
