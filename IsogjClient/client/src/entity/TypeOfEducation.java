package entity;



/**
 * Created by Vadim on 06.11.2017.
 * type of education entity
 */

public class TypeOfEducation {

    private int idTypeOfEducation;

    /**
     * name of type education
     */

    private String nameTypeOfEducation;

    /**
     *
     * @return
     * id of type education
     */
    public int getIdTypeOfEducation() {
        return idTypeOfEducation;
    }

    /**
     *
     * @param idTypeOfEducation
     * set id type of education
     */
    public void setIdTypeOfEducation(int idTypeOfEducation) {
        this.idTypeOfEducation = idTypeOfEducation;
    }

    /**
     *
     * @return
     * name of type of education
     */
    public String getNameTypeOfEducation() {
        return nameTypeOfEducation;
    }

    /**
     *
     * @param nameTypeOfEducation
     * set name of type education
     */
    public void setNameTypeOfEducation(String nameTypeOfEducation) {
        this.nameTypeOfEducation = nameTypeOfEducation;
    }
}
