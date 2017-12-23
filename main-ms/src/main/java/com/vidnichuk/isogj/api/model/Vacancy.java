package com.vidnichuk.isogj.api.model;

import com.vidnichuk.isogj.api.model.type.TypeOfVacancy;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vadim on 06.11.2017.
 * Vacancy entity
 */

@Entity
@Table(name = "Vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * info of vacancy
     */
    private String info;

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
     * company of vacancy
     */
    @ManyToOne
    @JoinColumn(name = "Company")
    private Company company;

    /**
     * @return company object
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company set company object
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return type of vacancy object
     */
    public TypeOfVacancy getTypeOfVacancy() {
        return typeOfVacancy;
    }

    /**
     * @param typeOfVacancy set type of vacancy
     */
    public void setTypeOfVacancy(TypeOfVacancy typeOfVacancy) {
        this.typeOfVacancy = typeOfVacancy;
    }

    /**
     * @return id of vacancy
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id ov vacancy
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return id of vacancy
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info set id of vacancy
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return task object
     */
    public Task getTask() {
        return task;
    }

    /**
     * @param task set task object
     */
    public void setTask(Task task) {
        this.task = task;
    }

}
