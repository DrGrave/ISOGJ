package com.vidnichuk.isogj.api.model;

import com.vidnichuk.isogj.api.model.type.TypeOfLink;

import javax.persistence.*;

@Entity
@Table(name = "UserLink")
public class UserLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "TypeOfLink")
    private TypeOfLink typeOfLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeOfLink getTypeOfLink() {
        return typeOfLink;
    }

    public void setTypeOfLink(TypeOfLink typeOfLink) {
        this.typeOfLink = typeOfLink;
    }
}
