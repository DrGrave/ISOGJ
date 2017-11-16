package entity;



/**
 * Created by Vadim on 06.11.2017.
 * type of vacancy entity
 */

public class TypeOfVacancy {


    private int idTypeOfVacancy;

    /**
     * name of type of vacancy
     */

    private int nameTypeOfVacancy;

    /**
     *
     * @return
     * id type of vacancy
     */
    public int getIdTypeOfVacancy() {
        return idTypeOfVacancy;
    }

    /**
     *
     * @param idTypeOfVacancy
     * set id type of vacancy
     */
    public void setIdTypeOfVacancy(int idTypeOfVacancy) {
        this.idTypeOfVacancy = idTypeOfVacancy;
    }

    /**
     *
     * @return
     * name type of vacancy
     */
    public int getNameTypeOfVacancy() {
        return nameTypeOfVacancy;
    }

    /**
     *
     * @param nameTypeOfVacancy
     * set name type of vacancy
     */
    public void setNameTypeOfVacancy(int nameTypeOfVacancy) {
        this.nameTypeOfVacancy = nameTypeOfVacancy;
    }

}
