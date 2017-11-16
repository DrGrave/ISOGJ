package entity;



/**
 * Created by Vadim on 03.11.2017.
 * type of skill
 */

public class TypeOfSkill {

    /**
     * id of type
     */

    private int idTypeOfSkill;

    /**
     * name of type
     */

    private String nameOfTypeSkill;

    /**
     *
     * @return
     * id of type
     */
    public int getIdTypeOfSkill() {
        return idTypeOfSkill;
    }

    /**
     *
     * @param idTypeOfSkill
     * set id of type
     */
    public void setIdTypeOfSkill(int idTypeOfSkill) {
        this.idTypeOfSkill = idTypeOfSkill;
    }

    /**
     *
     * @return
     * name of type
     */
    public String getNameOfTypeSkill() {
        return nameOfTypeSkill;
    }

    /**
     *
     * @param nameOfTypeSkill
     * set name of type
     */
    public void setNameOfTypeSkill(String nameOfTypeSkill) {
        this.nameOfTypeSkill = nameOfTypeSkill;
    }
}
