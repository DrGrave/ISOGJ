package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 07.11.2017.
 * many to many entity vacancy skill
 */
@Entity
@Table(name = "VacancySkill")
public class VacancySkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacancySkill;

    @ManyToOne
        @JoinColumn(name = "Vacancy")
    private Vacancy vacancy;

    @ManyToOne
        @JoinColumn(name = "Skill")
    private Skill skill;

    public int getIdVacancySkill() {
        return idVacancySkill;
    }

    public void setIdVacancySkill(int idVacancySkill) {
        this.idVacancySkill = idVacancySkill;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
