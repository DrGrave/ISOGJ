package entity;


/**
 * Created by Vadim on 07.11.2017.
 * University entity
 */

public class University {

    private int idUniversity;

    /**
     * name of university
     */

    private String nameOfUniversity;

    /**
     * city of locate university
     */

    private City city;

    /**
     *
     * @return
     * city of locate university
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * set city of locate university
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     * id of university
     */
    public int getIdUniversity() {
        return idUniversity;
    }

    /**
     *
     * @param idUniversity
     * set id of university
     */
    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    /**
     *
     * @return
     * name of university
     */
    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    /**
     *
     * @param nameOfUniversity
     * set name of university
     */
    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }
}
