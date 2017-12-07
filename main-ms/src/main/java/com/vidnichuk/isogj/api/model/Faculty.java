package com.vidnichuk.isogj.api.model;

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
    private Long id;

    private String name;

    /**
     * object of university
     */
    @ManyToOne
    @JoinColumn(name = "University")
    private University university;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * id of faculty
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * set id of faculty
     */
    public void setId(Long id) {
        this.id = id;
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
