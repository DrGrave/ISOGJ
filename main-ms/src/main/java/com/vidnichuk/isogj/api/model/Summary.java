package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * summary of user
 */
@Entity
@Table(name = "Summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * text of summary
     */
    private String text;

    /**
     * user object
     */
    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    /**
     * @return user object
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user set user object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return id of summary
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of summary
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return text of summary
     */
    public String getText() {
        return text;
    }

    /**
     * @param text set text of summary
     */
    public void setText(String text) {
        this.text = text;
    }
}
