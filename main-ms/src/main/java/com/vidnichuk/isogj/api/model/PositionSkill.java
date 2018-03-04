package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

@Entity
@Table(name = "PositionSkill")
public class PositionSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Psition")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "Skill")
    private Skill skill;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
