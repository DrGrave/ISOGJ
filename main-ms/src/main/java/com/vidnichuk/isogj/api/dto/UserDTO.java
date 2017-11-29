package com.vidnichuk.isogj.api.dto;

/**
 * User dto object
 */
public class UserDTO {
    /**
     * user id
     */
    private int userId;

    /**
     * user name
     */
    private String userName;
    /**
     * user surname
     */
    private String userSurname;
    /**
     * user patronymic
     */
    private String userLastName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

}
