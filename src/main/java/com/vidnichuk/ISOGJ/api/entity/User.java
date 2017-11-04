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
     * password of user
     */


    @Column(name = "UserPassword")
    @Length(min = 6, message = "*Your password must have at least 6 characters")
    @NotEmpty(message = "*Please provide your password")
    //@Transient
    private String userPassword;

    /**
     * gender of user
     */

    @ManyToOne
    @JoinColumn(name = "Gender")
    private Gender gender;

    /**
     * user role many to many
     */

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    /**
     *
     * @return
     * user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

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

    public void setActive(int active) {
        this.active = active;
    }

    /**
     *
     * @return
     * role of user
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     * set role to user
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
