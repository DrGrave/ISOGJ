package com.vidnichuk.isogj.api.dto.model;



public class MeUserDto {
    private String uid;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private CityDto city;

    private GenderDto gender;

    private TypeOfUserDto typeOfUser;

    public TypeOfUserDto getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(TypeOfUserDto typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public GenderDto getGender() {
        return gender;
    }

    public void setGender(GenderDto gender) {
        this.gender = gender;
    }
}
