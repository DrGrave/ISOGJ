package entity;

/**
 * Created by Vadim on 06.11.2017.
 * type of task entity
 */
public class TypeOfTask {

    private int idTypeOfTask;

    /**
     * name of type of task
     */
    private String nameTypeOfTask;

    /**
     *
     * @return
     * id of type of task
     */
    public int getIdTypeOfTask() {
        return idTypeOfTask;
    }

    /**
     *
     * @param idTypeOfTask
     * set id of type task
     */
    public void setIdTypeOfTask(int idTypeOfTask) {
        this.idTypeOfTask = idTypeOfTask;
    }

    /**
     *
     * @return
     * name of type of task
     */
    public String getNameTypeOfTask() {
        return nameTypeOfTask;
    }

    /**
     *
     * @param nameTypeOfTask
     * set name of type of task
     */
    public void setNameTypeOfTask(String nameTypeOfTask) {
        this.nameTypeOfTask = nameTypeOfTask;
    }
}
