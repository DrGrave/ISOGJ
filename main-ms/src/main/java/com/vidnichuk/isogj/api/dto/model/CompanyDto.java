package com.vidnichuk.isogj.api.dto.model;


/**
 * companyDTO object
 */
public class CompanyDto {
    private long id;
    private String name;
    private CityDto cityOfCompany;
    private String companyLogo;

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDto getCityOfCompany() {
        return cityOfCompany;
    }

    public void setCityOfCompany(CityDto cityOfCompany) {
        this.cityOfCompany = cityOfCompany;
    }


}
