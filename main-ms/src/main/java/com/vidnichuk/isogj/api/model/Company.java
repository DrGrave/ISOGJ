package com.vidnichuk.isogj.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vadim on 06.11.2017.
 * info of work company
 */
@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of company
     */

    private String name;

    /**
     * city of locate company
     */
    @ManyToOne
    @JoinColumn(name = "CityOfCompany")
    private City cityOfCompany;

    /**
     * info of company
     */
    private String info;

    /**
     * date of creation company
     */
    private Date dateOfCreation;

    @Column(name = "CompanyLogo")
    private String companyLogo;

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    /**
     * @return id of company
     */
    public Long getId() {
        return id;
    }

    /**
     * @param idOfCompany set id of info company
     */
    public void setId(Long idOfCompany) {
        this.id = idOfCompany;
    }

    /**
     * @return name of company
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name of company
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return city of locate company
     */
    public City getCityOfCompany() {
        return cityOfCompany;
    }

    /**
     * @param cityOfCompany set city of locate company
     */
    public void setCityOfCompany(City cityOfCompany) {
        this.cityOfCompany = cityOfCompany;
    }

    /**
     * @return info of company
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info set info of company
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return date of creation company
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * @param dateOfCreation set date of creation company
     */
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
