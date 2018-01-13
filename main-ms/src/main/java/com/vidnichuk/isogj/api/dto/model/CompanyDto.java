package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.City;

/**
 * companyDTO object
 */
public class CompanyDto {
    private long id;
    private String name;
    private City city;

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
