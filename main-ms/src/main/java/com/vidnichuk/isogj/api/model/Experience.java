package com.vidnichuk.isogj.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vadim on 06.11.2017.
 * experience entity
 */
@Entity
@Table(name = "Experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * date of start work
     */
    @Column(name = "DateOfStart")
    private Date dateOfStart;

    /**
     * date of end work
     */
    @Column(name = "DateOfEnd")
    private Date dateOfEnd;

    /**
     * previous company of work user
     */
    @ManyToOne
    @JoinColumn(name = "PrevCompany")
    private Company company;

    /**
     * user
     */
    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Position")
    private Position position;

    /**
     * @return previous company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company set previous company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return user
     */
    public User getUser() {
        return user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @param user set user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return id of experience
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of experience
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return date of start work
     */
    public Date getDateOfStart() {
        return dateOfStart;
    }

    /**
     * @param dateOfStart set date of start of work
     */
    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    /**
     * @return date of end work
     */
    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    /**
     * @param dateOfEnd set date of end of work
     */
    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

}
