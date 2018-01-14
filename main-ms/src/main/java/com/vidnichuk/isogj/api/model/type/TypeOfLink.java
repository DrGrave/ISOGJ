package com.vidnichuk.isogj.api.model.type;

import javax.persistence.*;

@Entity
@Table(name = "TypeOfLink")
public class TypeOfLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
