package com.vidnichuk.ISOGJ.api.entity;

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

    @Column(name = "InfoOfVacancy")
    private String infoOfVacancy;

    @ManyToOne
        @JoinColumn(name = "Task")
    private Task task;

    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public String getInfoOfVacancy() {
        return infoOfVacancy;
    }

    public void setInfoOfVacancy(String infoOfVacancy) {
        this.infoOfVacancy = infoOfVacancy;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}
