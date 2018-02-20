package com.vidnichuk.isogj.api.model;

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
    private Long idUserCompany;

    @Column(name = "CompanyApprove")
    private Boolean companyApprove;

    @Column(name = "ChangeApprove")
    private Boolean changeApprove;
    /**
     * user object
     */
    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    /**
     * company object
     */
    @ManyToOne
    @JoinColumn(name = "Company")
    private Company company;

    /**
     * position in company object
     */
    @ManyToOne
    @JoinColumn(name = "Position")
    private Position position;

    /**
     * @return id of user company
     */
    public Long getIdUserCompany() {
        return idUserCompany;
    }

    public Boolean getChangeApprove() {
        return changeApprove;
    }

    public void setChangeApprove(Boolean changeApprove) {
        this.changeApprove = changeApprove;
    }

    /**
     * @param idUserCompany set id of user company
     */


    public void setIdUserCompany(Long idUserCompany) {
        this.idUserCompany = idUserCompany;
    }


    public Boolean getCompanyApprove() {
        return companyApprove;
    }

    public void setCompanyApprove(Boolean companyApprove) {
        this.companyApprove = companyApprove;
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
     * @return company object
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company set company object
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return position in company object
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position set position in company
     */
    public void setPosition(Position position) {
        this.position = position;
    }
}
