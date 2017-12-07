package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * position of user in company
 */
@Entity
@Table(name = "Position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of position in job
     */
    private String name;

    /**
     * @return id of position
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of position
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name of position
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name of position
     */
    public void setName(String name) {
        this.name = name;
    }
}
