package com.vidnichuk.ISOGJ.api.entity;

import javafx.beans.DefaultProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by vadim on 16.10.17.
 * entity of user in system
 */
@Entity
@Table(name = "user")
public class User {
    /**
     * id of user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    /**
     * name of user
     */

    @Column(name = "UserName", nullable = false)
    @NotEmpty(message = "*Please provide your name")
    private String userName;

    /**
     * surname of user
     */

    @Column(name = "UserSurname", nullable = false)
    @NotEmpty(message = "*Please provide your surname")
    private String userSurname;

    /**
     * is user online
     */
    @Column(name = "active")
    private int active;

    /**
     * patronymic of user
     */
    @Column(name = "UserPatronymic", nullable = false)
    @NotEmpty(message = "*Please provide your Patronymic")
    private String userPatronymic;



    /**
     * email of user
     */
    @Column(name = "Email", nullable = false)
    @Email(message = "*Please provide a valid email")
    @NotEmpty(message = "*Please provide a email")
    private String userEmail;



    /**
     * gender of user
     */
    @ManyToOne
    @JoinColumn(name = "Gender")
    private Gender gender;

    /**
     * type of user
     */
    @ManyToOne
    @JoinColumn(name = "TypeOfUser")
    private TypeOfUser typeOfUser;

    /**
     * city of living
     */
    @ManyToOne
        @JoinColumn(name = "CityOfLiving")
    private City city;


    /**
     *
     * @return
     * city of living
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * set city of livng
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     * type of user object
     */
    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    /**
     *
     * @param typeOfUser
     * set type of user object
     */
    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    /**
     *
     * @return
     * id of user
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * set id of user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     * set user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     * user surname
     */
    public String getUserSurname() {
        return userSurname;
    }

    /**
     *
     * @param userSurname
     * set user surname
     */
    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    /**
     *
     * @return
     * user patronymic
     */
    public String getUserPatronymic() {
        return userPatronymic;
    }

    /**
     *
     * @param userPatronymic
     * set user patronymic
     */
    public void setUserPatronymic(String userPatronymic) {
        this.userPatronymic = userPatronymic;
    }

    /**
     *
     * @return
     * user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     *
     * @param userEmail
     * set user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     *
     * @return
     * user gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * user gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * 1 is user online and 0 if user offline
     */
    public int getActive() {
        return active;
    }

    /**
     *
     * @param active
     * set active
     */
    public void setActive(int active) {
        this.active = active;
    }


}
