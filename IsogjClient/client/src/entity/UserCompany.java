package entity;


/**
 * Created by Vadim on 06.11.2017.
 * many to many user company entity
 */


public class UserCompany {


    private int idUserCompany;

    /**
     * user object
     */

    private User user;

    /**
     * company object
     */


    private Company company;

    /**
     * position in company object
     */


    private Position position;

    /**
     *
     * @return
     * id of user company
     */
    public int getIdUserCompany() {
        return idUserCompany;
    }

    /**
     *
     * @param idUserCompany
     * set id of user company
     */
    public void setIdUserCompany(int idUserCompany) {
        this.idUserCompany = idUserCompany;
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
     * company object
     */
    public Company getCompany() {
        return company;
    }

    /**
     *
     * @param company
     * set company object
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     *
     * @return
     * position in company object
     */
    public Position getPosition() {
        return position;
    }

    /**
     *
     * @param position
     * set position in company
     */
    public void setPosition(Position position) {
        this.position = position;
    }
}
