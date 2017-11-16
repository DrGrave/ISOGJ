package com.vidnichuk.isogj.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * user city to work entity
 */
@Entity
@Table(name = "UserCityToWork")
public class UserCityToWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserCityToWork;

    /**
     * user object
     */
    @ManyToOne
        @JoinColumn(name = "User")
    private User user;

    /**
     * city object
     */
    @ManyToOne
        @JoinColumn(name = "City")
    private City city;

    /**
     *
     * @return
     * id city of work
     */
    public int getIdUserCityToWork() {
        return idUserCityToWork;
    }

    /**
     *
     * @param idUserCityToWork
     * set id of city of work
     */
    public void setIdUserCityToWork(int idUserCityToWork) {
        this.idUserCityToWork = idUserCityToWork;
    }

    /**
     *
     * @return
     * user object
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * set user object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * city object
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * set city object
     */
    public void setCity(City city) {
        this.city = city;
    }
}
