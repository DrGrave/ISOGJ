package entity;






/**
 * Type of user object
 */

public class TypeOfUser {


    /**
     * identity of user type
     */

    private int idTypeOfUser;

    /**
     * name of user type
     */

    private String nameOfTypeUser;

    /**
     *
     * @return
     * id of type
     */
    public int getIdTypeOfUser() {
        return idTypeOfUser;
    }

    /**
     *
     * @param idTypeOfUser
     * set id type of user
     */
    public void setIdTypeOfUser(int idTypeOfUser) {
        this.idTypeOfUser = idTypeOfUser;
    }

    /**
     *
     * @return
     * name of type user
     */
    public String getNameOfTypeUser() {
        return nameOfTypeUser;
    }

    /**
     *
     * @param nameOfTypeUser
     * set name of type user
     */
    public void setNameOfTypeUser(String nameOfTypeUser) {
        this.nameOfTypeUser = nameOfTypeUser;
    }
}
