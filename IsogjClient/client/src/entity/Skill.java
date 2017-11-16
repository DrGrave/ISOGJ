package entity;


/**
 * Created by Vadim on 02.11.2017.
 * class to skills to user
 */


public class Skill {

    /**
     * id of skill
     */
    private int idSkill;

    /**
     * name of skill
     */
    private String nameOfSkill;

    /**
     * type of skill
     */
    private TypeOfSkill typeOfSkill;

    /**
     *
     * @return
     * type of skill
     */
    public TypeOfSkill getTypeOfSkill() {
        return typeOfSkill;
    }

    /**
     *
     * @param typeOfSkill
     * set type of skill
     */
    public void setTypeOfSkill(TypeOfSkill typeOfSkill) {
        this.typeOfSkill = typeOfSkill;
    }

    /**
     *
     * @return
     * return id of skill
     */
    public int getIdSkill() {
        return idSkill;
    }

    /**
     *
     * @param idSkill
     * get id of skill
     */
    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    /**
     *
     * @return
     * return name of skill
     */
    public String getNameOfSkill() {
        return nameOfSkill;
    }

    /**
     *
     * @param nameOfSkill
     * set name of skill to object
     */
    public void setNameOfSkill(String nameOfSkill) {
        this.nameOfSkill = nameOfSkill;
    }
}
