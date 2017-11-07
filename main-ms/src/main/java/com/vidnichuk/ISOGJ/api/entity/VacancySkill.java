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

    /**
     * vacancy object
     */
    @ManyToOne
        @JoinColumn(name = "Vacancy")
    private Vacancy vacancy;

    /**
     * skill object
     */
    @ManyToOne
        @JoinColumn(name = "Skill")
    private Skill skill;

    /**
     *
     * @return
     * id of vacancy skill
     */
    public int getIdVacancySkill() {
        return idVacancySkill;
    }

    /**
     *
     * @param idVacancySkill
     * set id of vacancy skill
     */
    public void setIdVacancySkill(int idVacancySkill) {
        this.idVacancySkill = idVacancySkill;
    }

    /**
     *
     * @return
     * vacancy object
     */
    public Vacancy getVacancy() {
        return vacancy;
    }

    /**
     *
     * @param vacancy
     * set vacancy object
     */
    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    /**
     *
     * @return
     * skill object
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     *
     * @param skill
     * set skill object
     */
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
