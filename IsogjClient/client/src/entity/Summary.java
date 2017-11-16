package entity;


/**
 * Created by Vadim on 06.11.2017.
 * summary of user
 */

public class Summary {


    private int idOfSummary;

    /**
     * text of summary
     */

    private String textOfSummary;

    /**
     * user object
     */

    private User user;

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
     * id of summary
     */
    public int getIdOfSummary() {
        return idOfSummary;
    }

    /**
     *
     * @param idOfSummary
     * set id of summary
     */
    public void setIdOfSummary(int idOfSummary) {
        this.idOfSummary = idOfSummary;
    }

    /**
     *
     * @return
     * text of summary
     */
    public String getTextOfSummary() {
        return textOfSummary;
    }

    /**
     *
     * @param textOfSummary
     * set text of summary
     */
    public void setTextOfSummary(String textOfSummary) {
        this.textOfSummary = textOfSummary;
    }
}
