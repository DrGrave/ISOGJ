package com.vidnichuk.ISOGJ.api.entity;

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

    @ManyToOne
        @JoinColumn(name = "User")
    private User user;

    @ManyToOne
        @JoinColumn(name = "City")
    private City city;

    public int getIdUserCityToWork() {
        return idUserCityToWork;
    }

    public void setIdUserCityToWork(int idUserCityToWork) {
        this.idUserCityToWork = idUserCityToWork;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
