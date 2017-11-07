package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * education entity
 */
@Entity
@Table(name = "Education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfEducation;

    /**
     * type of education
     */
    @ManyToOne
        @JoinColumn(name = "TypeOfEducation")
    private TypeOfEducation typeOfEducation;

    /**
     * faculty of university
     */
    @ManyToOne
        @JoinColumn(name = "Faculty")
    private Faculty faculty;

    /**
     * school of education
     */
    @ManyToOne
        @JoinColumn(name = "School")
    private School school;

    /**
     *
     * @return
     * id of education
     */
    public int getIdOfEducation() {
        return idOfEducation;
    }

    /**
     *
     * @param idOfEducation
     * set id of education
     */
    public void setIdOfEducation(int idOfEducation) {
        this.idOfEducation = idOfEducation;
    }

    /**
     *
     * @return
     * type of education
     */
    public TypeOfEducation getTypeOfEducation() {
        return typeOfEducation;
    }

    /**
     *
     * @param typeOfEducation
     * set type of education
     */
    public void setTypeOfEducation(TypeOfEducation typeOfEducation) {
        this.typeOfEducation = typeOfEducation;
    }

    /**
     *
     * @return
     * faculty object
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     *
     * @param faculty
     * set faculty object
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     *
     * @return
     * school object
     */
    public School getSchool() {
        return school;
    }

    /**
     *
     * @param school
     * set school object
     */
    public void setSchool(School school) {
        this.school = school;
    }
}
