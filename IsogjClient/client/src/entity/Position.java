package entity;


/**
 * Created by Vadim on 06.11.2017.
 * position of user in company
 */
public class Position {

    private int idOfPosition;

    /**
     * name of position in job
     */

    private String nameOfPosition;

    /**
     *
     * @return
     * id of position
     */
    public int getIdOfPosition() {
        return idOfPosition;
    }

    /**
     *
     * @param idOfPosition
     * set id of position
     */
    public void setIdOfPosition(int idOfPosition) {
        this.idOfPosition = idOfPosition;
    }

    /**
     *
     * @return
     * name of position
     */
    public String getNameOfPosition() {
        return nameOfPosition;
    }

    /**
     *
     * @param nameOfPosition
     * set name of position
     */
    public void setNameOfPosition(String nameOfPosition) {
        this.nameOfPosition = nameOfPosition;
    }
}
