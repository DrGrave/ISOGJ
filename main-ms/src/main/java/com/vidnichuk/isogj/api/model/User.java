package com.vidnichuk.isogj.api.model;

import com.vidnichuk.isogj.api.model.type.TypeOfUser;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
    private Long id;


    /**
     * username for identification and synchronization with other services.
     */
    @Column(name = "username", nullable = false)
    private String username;


    /**
     * name of user
     */

    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "*Please provide your name")
    private String firstName;

    /**
     * surname of user
     */

    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "*Please provide your surname")
    private String lastName;

    /**
     * is user online
     */
    private Boolean active;

    /**
     * patronymic of user
     */
    @Column(name = "middle_name", nullable = false)
    private String middleName;


    /**
     * email of user
     */
    @Column(name = "Email", nullable = false)
    @Email(message = "*Please provide a valid email")
    @NotEmpty(message = "*Please provide a email")
    private String email;


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


    @ManyToMany
    @JoinTable(name = "possible_cities_to_work",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_city")})
    private Set<City> possibleCitiesToWork;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return city of living
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city set city of livng
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return type of user object
     */
    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    /**
     * @param typeOfUser set type of user object
     */
    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    /**
     * @return id of user
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of user
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName set user name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return user surname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName set user surname
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return user patronymic
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName set user patronymic
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email set user email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return user gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender user gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return 1 is user online and 0 if user offline
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active set active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }


    public Set<City> getPossibleCitiesToWork() {
        return possibleCitiesToWork;
    }

    public void setPossibleCitiesToWork(Set<City> possibleCitiesToWork) {
        this.possibleCitiesToWork = possibleCitiesToWork;
    }
}
