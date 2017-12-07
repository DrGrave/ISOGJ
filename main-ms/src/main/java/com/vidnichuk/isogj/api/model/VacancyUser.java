package com.vidnichuk.isogj.api.model;

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
    private Long id;

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
    private Boolean ifAcceptedUser;

    /**
     * if company accept
     */
    private Boolean ifCompanyAccepted;

    /**
     * @return id of vacancy user
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of vacancy
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return vacancy object
     */
    public Vacancy getVacancy() {
        return vacancy;
    }

    /**
     * @param vacancy set vacancy object
     */
    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    /**
     * @return user object
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user set user object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return if accept user object
     */
    public Boolean getIfAcceptedUser() {
        return ifAcceptedUser;
    }

    /**
     * @param ifAcceptedUser set if accept user
     */
    public void setIfAcceptedUser(Boolean ifAcceptedUser) {
        this.ifAcceptedUser = ifAcceptedUser;
    }

    /**
     * @return if company accept user
     */
    public Boolean getIfCompanyAccepted() {
        return ifCompanyAccepted;
    }

    /**
     * @param ifCompanyAccepted set if company accept user
     */
    public void setIfCompanyAccepted(Boolean ifCompanyAccepted) {
        this.ifCompanyAccepted = ifCompanyAccepted;
    }
}
