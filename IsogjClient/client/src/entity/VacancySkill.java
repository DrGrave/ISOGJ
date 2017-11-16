package entity;


/**
 * Created by Vadim on 07.11.2017.
 * many to many entity vacancy skill
 */

public class VacancySkill {

    private int idVacancySkill;

    /**
     * vacancy object
     */

    private Vacancy vacancy;

    /**
     * skill object
     */

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
