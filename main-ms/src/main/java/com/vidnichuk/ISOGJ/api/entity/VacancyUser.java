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

    /**
     * vacancy object
     */
    @ManyToOne
        @JoinColumn(name = "Vacancy")
    private Vacancy vacancy;

    /**
     * user object
     */
    @ManyToOne
        @JoinColumn(name = "User")
    private User user;


    /**
     * if accept user
     */
    @ManyToOne
        @JoinColumn(name = "IfUserAccepted")
    private TypeOfAccepted ifAcceptedUser;

    /**
     * if company accept
     */
    @ManyToOne
        @JoinColumn(name = "IfCompanyAccepted")
    private TypeOfAccepted ifCompanyAccepted;

    /**
     *
     * @return
     * id of vacancy user
     */
    public int getIdVacancyUser() {
        return idVacancyUser;
    }

    /**
     *
     * @param idVacancyUser
     * set id of vacancy
     */
    public void setIdVacancyUser(int idVacancyUser) {
        this.idVacancyUser = idVacancyUser;
    }

    /**
     *
     * @return
     * vacancy object
     */
    public Vacancy getVacancy() {
        return vacancy;
    }

    /**
     *
     * @param vacancy
     * set vacancy object
     */
    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
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
     * if accept user object
     */
    public TypeOfAccepted getIfAcceptedUser() {
        return ifAcceptedUser;
    }

    /**
     *
     * @param ifAcceptedUser
     * set if accept user
     */
    public void setIfAcceptedUser(TypeOfAccepted ifAcceptedUser) {
        this.ifAcceptedUser = ifAcceptedUser;
    }

    /**
     *
     * @return
     * if company accept user
     */
    public TypeOfAccepted getIfCompanyAccepted() {
        return ifCompanyAccepted;
    }

    /**
     *
     * @param ifCompanyAccepted
     * set if company accept user
     */
    public void setIfCompanyAccepted(TypeOfAccepted ifCompanyAccepted) {
        this.ifCompanyAccepted = ifCompanyAccepted;
    }
}
