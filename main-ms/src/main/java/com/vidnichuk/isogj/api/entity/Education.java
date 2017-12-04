package com.vidnichuk.isogj.api.entity;

import com.vidnichuk.isogj.api.entity.type.TypeOfEducation;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vadim on 06.11.2017.
 * education entity
 */
@Entity
@Table(name = "Education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Faculty faculty;

    /**
     * school of education
     */
    @ManyToOne
    @JoinColumn(name = "School")
    private School school;

    /**
     * user entity
     */
    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    /**
     * date of start of education
     */
    @Column(name = "StartOfEducation")
    private Date dateOfStart;

    /**
     * date of end education
     */
    @Column(name = "EndOfEducation")
    private Date dateOfEnd;


    /**
     *
     * @return
     * user object
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * set object user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * date of start education
     */
    public Date getDateOfStart() {
        return dateOfStart;
    }

    /**
     *
     * @param dateOfStart
     * set date of start work
     */
    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    /**
     *
     * @return
     * date of end education
     */
    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    /**
     *
     * @param dateOfEnd
     * set date of end education
     */
    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    /**
     *
     * @return
     * id of education
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set id of education
     */
    public void setId(Long id) {
        this.id = id;
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
