package entity;


/**
 * Created by Vadim on 06.11.2017.
 * faculty entity
 */
public class Faculty {

    private int idFaculty;

    /**
     * object of university
     */

    private University university;

    /**
     *
     * @return
     * id of faculty
     */
    public int getIdFaculty() {
        return idFaculty;
    }

    /**
     *
     * @param idFaculty
     * set id of faculty
     */
    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    /**
     *
     * @return
     * university object
     */
    public University getUniversity() {
        return university;
    }

    /**
     *
     * @param university
     * set university object
     */
    public void setUniversity(University university) {
        this.university = university;
    }
}
