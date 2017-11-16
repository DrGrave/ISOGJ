package entity;

public class School {

    private int idSchool;

    /**
     * city of school location
     */

    private City city;

    /**
     * name of school
     */

    private String nameOfSchool;

    /**
     *
     * @return
     * id of school
     */
    public int getIdSchool() {
        return idSchool;
    }

    /**
     *
     * @param idSchool
     * set id of school
     */
    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    /**
     *
     * @return
     * city of school location
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * set city of location
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     * name of school
     */
    public String getNameOfSchool() {
        return nameOfSchool;
    }

    /**
     *
     * @param nameOfSchool
     * set name of school
     */
    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }
}
