package entity;



import java.util.Date;

/**
 * Created by Vadim on 06.11.2017.
 * education entity
 */

public class Education {

    private int idOfEducation;

    /**
     * type of education
     */

    private TypeOfEducation typeOfEducation;

    /**
     * faculty of university
     */

    private Faculty faculty;

    /**
     * school of education
     */

    private School school;

    /**
     * user entity
     */

    private User user;

    /**
     * date of start of education
     */

    private Date dateOfStart;

    /**
     * date of end education
     */

    private Date dateOfEnd;


    /**
     *
     * @return
     * user object
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * set object user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * date of start education
     */
    public Date getDateOfStart() {
        return dateOfStart;
    }

    /**
     *
     * @param dateOfStart
     * set date of start work
     */
    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    /**
     *
     * @return
     * date of end education
     */
    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    /**
     *
     * @param dateOfEnd
     * set date of end education
     */
    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    /**
     *
     * @return
     * id of education
     */
    public int getIdOfEducation() {
        return idOfEducation;
    }

    /**
     *
     * @param idOfEducation
     * set id of education
     */
    public void setIdOfEducation(int idOfEducation) {
        this.idOfEducation = idOfEducation;
    }

    /**
     *
     * @return
     * type of education
     */
    public TypeOfEducation getTypeOfEducation() {
        return typeOfEducation;
    }

    /**
     *
     * @param typeOfEducation
     * set type of education
     */
    public void setTypeOfEducation(TypeOfEducation typeOfEducation) {
        this.typeOfEducation = typeOfEducation;
    }

    /**
     *
     * @return
     * faculty object
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     *
     * @param faculty
     * set faculty object
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     *
     * @return
     * school object
     */
    public School getSchool() {
        return school;
    }

    /**
     *
     * @param school
     * set school object
     */
    public void setSchool(School school) {
        this.school = school;
    }
}
