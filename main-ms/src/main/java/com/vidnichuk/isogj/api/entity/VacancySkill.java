package com.vidnichuk.isogj.api.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vadim on 07.11.2017.
 * many to many entity vacancy skill
 */
@Entity
@Table(name = "VacancySkill")
public class VacancySkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set id of vacancy skill
     */
    public void setId(Long id) {
        this.id = id;
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
