package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Vadim on 06.11.2017.
 * summary of user
 */
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfSummary;

    /**
     * text of summary
     */
    @Column(name = "TextOfSummary")
    private String textOfSummary;

    /**
     *
     * @return
     * id of summary
     */
    public int getIdOfSummary() {
        return idOfSummary;
    }

    /**
     *
     * @param idOfSummary
     * set id of summary
     */
    public void setIdOfSummary(int idOfSummary) {
        this.idOfSummary = idOfSummary;
    }

    /**
     *
     * @return
     * text of summary
     */
    public String getTextOfSummary() {
        return textOfSummary;
    }

    /**
     *
     * @param textOfSummary
     * set text of summary
     */
    public void setTextOfSummary(String textOfSummary) {
        this.textOfSummary = textOfSummary;
    }
}
