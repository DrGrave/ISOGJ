package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * many to many user company entity
 */
@Entity
@Table(name = "UserCompany")
public class UserCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserCompany;

    @ManyToOne
        @JoinColumn(name = "User")
    private User user;

    @ManyToOne
        @JoinColumn(name = "Company")
    private Company company;

    @ManyToOne
        @JoinColumn(name = "Position")
    private Position position;

    public int getIdUserCompany() {
        return idUserCompany;
    }

    public void setIdUserCompany(int idUserCompany) {
        this.idUserCompany = idUserCompany;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
