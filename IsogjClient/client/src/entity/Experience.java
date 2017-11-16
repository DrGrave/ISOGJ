package entity;

import java.util.Date;

/**
 * Created by Vadim on 06.11.2017.
 * experience entity
 */

public class Experience {

    private int idExperience;

    /**
     * date of start work
     */
    private Date dateOfStart;

    /**
     * date of end work
     */
    private Date dateOfEnd;

    /**
     * previous company of work user
     */
    private Company company;

    /**
     * user
     */
    private User user;

    /**
     *
     * @return
     * previous company
     */
    public Company getCompany() {
        return company;
    }

    /**
     *
     * @param company
     * set previous company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     *
     * @return
     * user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * set user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * id of experience
     */
    public int getIdExperience() {
        return idExperience;
    }

    /**
     *
     * @param idExperience
     * set id of experience
     */
    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }

    /**
     *
     * @return
     * date of start work
     */
    public Date getDateOfStart() {
        return dateOfStart;
    }

    /**
     *
     * @param dateOfStart
     * set date of start of work
     */
    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    /**
     *
     * @return
     * date of end work
     */
    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    /**
     *
     * @param dateOfEnd
     * set date of end of work
     */
    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

}
