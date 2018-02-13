package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

@Entity
@Table(name = "VacancyTask")
public class VacancyTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Vacancy")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "Task")
    private Task task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
