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

    @ManyToOne
        @JoinColumn(name = "TypeOfEducation")
    private TypeOfEducation typeOfEducation;
    
    @ManyToOne
        @JoinColumn(name = "Faculty")
    private Faculty faculty;
    
    @ManyToOne
        @JoinColumn(name = "School")
    private School school;

    // TODO: 06.11.2017 work with this entity 

    public int getIdOfEducation() {
        return idOfEducation;
    }

    public void setIdOfEducation(int idOfEducation) {
        this.idOfEducation = idOfEducation;
    }

    public TypeOfEducation getTypeOfEducation() {
        return typeOfEducation;
    }

    public void setTypeOfEducation(TypeOfEducation typeOfEducation) {
        this.typeOfEducation = typeOfEducation;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
