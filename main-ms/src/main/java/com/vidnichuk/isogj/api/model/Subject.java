package com.vidnichuk.isogj.api.model;


import javax.persistence.*;


/**
 * Created by Vadim on 022.01.2019.
 * class to subjects of department
 */
@Entity
@Table(name = "Subject")
public class Subject {

    /**
       id of subject
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * subject name
     */
    private String subjectName;


    /**
     * department witch work with this subject
     */
    @ManyToOne
    @JoinColumn(name = "Department", nullable = false)
    private  Department department;


    /**
     * getter for @id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * setter for id
     * @param id id of subject
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter for subject name
     * @return subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * setter for subject name
     * @param subjectName name of subject
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * getter for department
     * @return department witch work with this subject
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * setter for department
     * @param department department with witch work with this subject
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
}
