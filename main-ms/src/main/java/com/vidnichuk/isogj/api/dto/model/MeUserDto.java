package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.City;
import com.vidnichuk.isogj.api.model.Gender;

public class MeUserDto {
    private Long id;

    /**
     * user name
     */
    private String firstName;
    /**
     * user surname
     */
    private String lastName;
    /**
     * user patronymic
     */
    private String middleName;

    private String email;

    private City city;

    private Gender gender;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
