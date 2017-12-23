package com.vidnichuk.isogj.api.model;


import javax.persistence.*;

@Entity
@Table(name = "VacancySkill")
public class VacancySkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
        @JoinColumn(name = "Vacancy")
    private Vacancy vacancy;

    @ManyToOne
        @JoinColumn(name = "Skill")
    private Skill skill;

    private String expectedMark;


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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getExpectedMark() {
        return expectedMark;
    }

    public void setExpectedMark(String expectedMark) {
        this.expectedMark = expectedMark;
    }
}
