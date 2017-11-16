package entity;


/**
 * Created by Vadim on 02.11.2017.
 * Many to many class for user skills
 */


public class UserSkill {

    /**
     *  id of many to many object
     */


    private int idUserSkill;

    /**
     * id user to many to many object
     */


    private User idUser;

    /**
     * object of person who set the mark
     */


    private User idMarker;

    /**
     * id skill to many to many object
     */


    private Skill idSkill;

    /**
     * mark of theoretical skill
     */


    private String skillMark;

    /**
     * mark of practical skill
     */

    private String skillPracticalMark;


    public int getIdUserSkill() {
        return idUserSkill;
    }

    public void setIdUserSkill(int idUserSkill) {
        this.idUserSkill = idUserSkill;
    }

    /**
     *
     * @return
     * user who set the mark
     */
    public User getIdMarker() {
        return idMarker;
    }

    /**
     *
     * @param idMarker
     * set user who set the mark
     */
    public void setIdMarker(User idMarker) {
        this.idMarker = idMarker;
    }

    /**
     *
     * @return
     * return skill mark
     */
    public String getSkillMark() {
        return skillMark;
    }

    /**
     *
     * @param skillMark
     * set skill mark
     */
    public void setSkillMark(String skillMark) {
        this.skillMark = skillMark;
    }

    /**
     *
     * @return
     * return skill practical mark
     */
    public String getSkillPracticalMark() {
        return skillPracticalMark;
    }

    /**
     *
     * @param skillPracticalMark
     * set skill of practical mark
     */
    public void setSkillPracticalMark(String skillPracticalMark) {
        this.skillPracticalMark = skillPracticalMark;
    }

    /**
     *
     * @return
     * return user object
     */
    public User getIdUser() {
        return idUser;
    }

    /**
     *
     * @param idUser
     * set user object to many to many object
     */
    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    /**
     *
     * @return
     * return skill object
     */
    public Skill getIdSkill() {
        return idSkill;
    }

    /**
     *
     * @param idSkill
     * set skill object to many to many
     */
    public void setIdSkill(Skill idSkill) {
        this.idSkill = idSkill;
    }
}
