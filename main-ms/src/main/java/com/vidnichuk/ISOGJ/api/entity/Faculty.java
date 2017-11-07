package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * faculty entity
 */
@Entity
@Table(name = "Faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFaculty;

    /**
     * object of university
     */
    @ManyToOne
        @JoinColumn(name = "University")
    private University university;

    /**
     *
     * @return
     * id of faculty
     */
    public int getIdFaculty() {
        return idFaculty;
    }

    /**
     *
     * @param idFaculty
     * set id of faculty
     */
    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    /**
     *
     * @return
     * university object
     */
    public University getUniversity() {
        return university;
    }

    /**
     *
     * @param university
     * set university object
     */
    public void setUniversity(University university) {
        this.university = university;
    }
}
