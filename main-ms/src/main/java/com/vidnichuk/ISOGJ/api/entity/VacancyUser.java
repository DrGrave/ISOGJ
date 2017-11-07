package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 07.11.2017.
 * many to many entity vacancy user
 */
@Entity
@Table(name = "VacancyUser")
public class VacancyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacancyUser;

    @ManyToOne
        @JoinColumn(name = "Vacancy")
    private Vacancy vacancy;

    @ManyToOne
        @JoinColumn(name = "User")
    private User user;


    @ManyToOne
        @JoinColumn(name = "IfUserAccepted")
    private TypeOfAccepted ifAcceptedUser;

    @ManyToOne
        @JoinColumn(name = "IfCompanyAccepted")
    private TypeOfAccepted ifCompanyAccepted;

    public int getIdVacancyUser() {
        return idVacancyUser;
    }

    public void setIdVacancyUser(int idVacancyUser) {
        this.idVacancyUser = idVacancyUser;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeOfAccepted getIfAcceptedUser() {
        return ifAcceptedUser;
    }

    public void setIfAcceptedUser(TypeOfAccepted ifAcceptedUser) {
        this.ifAcceptedUser = ifAcceptedUser;
    }

    public TypeOfAccepted getIfCompanyAccepted() {
        return ifCompanyAccepted;
    }

    public void setIfCompanyAccepted(TypeOfAccepted ifCompanyAccepted) {
        this.ifCompanyAccepted = ifCompanyAccepted;
    }
}
