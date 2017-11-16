package com.vidnichuk.isogj.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * Vacancy entity
 */

@Entity
@Table(name = "Vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacancy;

    /**
     * info of vacancy
     */
    @Column(name = "InfoOfVacancy")
    private String infoOfVacancy;

    /**
     * type of vacancy object
     */
    @ManyToOne
        @JoinColumn(name = "TypeOfVacancy")
    private TypeOfVacancy typeOfVacancy;

    /**
     * task object
     */
    @ManyToOne
        @JoinColumn(name = "Task")
    private Task task;

    /**
     *
     * @return
     * type of vacancy object
     */
    public TypeOfVacancy getTypeOfVacancy() {
        return typeOfVacancy;
    }

    /**
     *
     * @param typeOfVacancy
     * set type of vacancy
     */
    public void setTypeOfVacancy(TypeOfVacancy typeOfVacancy) {
        this.typeOfVacancy = typeOfVacancy;
    }

    /**
     *
     * @return
     * id of vacancy
     */
    public int getIdVacancy() {
        return idVacancy;
    }

    /**
     *
     * @param idVacancy
     * set id ov vacancy
     */
    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    /**
     *
     * @return
     * id of vacancy
     */
    public String getInfoOfVacancy() {
        return infoOfVacancy;
    }

    /**
     *
     * @param infoOfVacancy
     * set id of vacancy
     */
    public void setInfoOfVacancy(String infoOfVacancy) {
        this.infoOfVacancy = infoOfVacancy;
    }

    /**
     *
     * @return
     * task object
     */
    public Task getTask() {
        return task;
    }

    /**
     *
     * @param task
     * set task object
     */
    public void setTask(Task task) {
        this.task = task;
    }

}
