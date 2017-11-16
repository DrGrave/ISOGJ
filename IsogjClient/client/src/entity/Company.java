package entity;


import java.util.Date;

/**
 * Created by Vadim on 06.11.2017.
 * info of work company
 */

public class Company {


    private int idCompany;

    /**
     * name of company
     */


    private String nameOfCompany;

    /**
     * city of locate company
     */

    private City cityOfCompany;

    /**
     * info of company
     */

    private String infoOfCompany;

    /**
     * date of creation company
     */

    private Date dateOfCreationCompany;

    /**
     *
     * @return
     * id of company
     */
    public int getIdOfCompany() {
        return idCompany;
    }

    /**
     *
     * @param idOfCompany
     * set id of info company
     */
    public void setIdOfCompany(int idOfCompany) {
        this.idCompany = idOfCompany;
    }

    /**
     *
     * @return
     * name of company
     */
    public String getNameOfCompany() {
        return nameOfCompany;
    }

    /**
     *
     * @param nameOfCompany
     * set name of company
     */
    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    /**
     *
     * @return
     * city of locate company
     */
    public City getCityOfCompany() {
        return cityOfCompany;
    }

    /**
     *
     * @param cityOfCompany
     * set city of locate company
     */
    public void setCityOfCompany(City cityOfCompany) {
        this.cityOfCompany = cityOfCompany;
    }

    /**
     *
     * @return
     * info of company
     */
    public String getInfoOfCompany() {
        return infoOfCompany;
    }

    /**
     *
     * @param infoOfCompany
     * set info of company
     */
    public void setInfoOfCompany(String infoOfCompany) {
        this.infoOfCompany = infoOfCompany;
    }

    /**
     *
     * @return
     * date of creation company
     */
    public Date getDateOfCreationCompany() {
        return dateOfCreationCompany;
    }

    /**
     *
     * @param dateOfCreationCompany
     * set date of creation company
     */
    public void setDateOfCreationCompany(Date dateOfCreationCompany) {
        this.dateOfCreationCompany = dateOfCreationCompany;
    }
}
