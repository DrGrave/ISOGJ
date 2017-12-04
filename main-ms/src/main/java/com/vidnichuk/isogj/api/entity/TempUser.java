package com.vidnichuk.isogj.api.entity;

public class TempUser {
    private int idUserRegistration;
    private String userPassword;
    private String userLogin;
    private String userEmail;
    private String userName;
    private String userSurname;
    private String userPatronymic;

    public int getIdUserRegistration() {
        return idUserRegistration;
    }

    public void setIdUserRegistration(int idUserRegistration) {
        this.idUserRegistration = idUserRegistration;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getUserPatronymic() {
        return userPatronymic;
    }

    public void setUserPatronymic(String userPatronymic) {
        this.userPatronymic = userPatronymic;
    }
}
