package com.vidnichuk.isogj.api.dto.model;

import java.util.Date;

/**
 * User dto object
 */
public class UserDto {
    /**
     * user id
     */
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

    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

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

}
