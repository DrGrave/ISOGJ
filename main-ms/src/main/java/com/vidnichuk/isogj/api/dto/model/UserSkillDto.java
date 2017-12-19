package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.Skill;
import com.vidnichuk.isogj.api.model.User;

import java.util.Date;

public class UserSkillDto {
    private Long id;
    private long marker;
    private Date startSkilling;
    private Date endSkilling;
    private String skillPracticalMark;
    private String skillMark;
    private Skill skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMarker() {
        return marker;
    }

    public void setMarker(long marker) {
        this.marker = marker;
    }

    public Date getStartSkilling() {
        return startSkilling;
    }

    public void setStartSkilling(Date startSkilling) {
        this.startSkilling = startSkilling;
    }

    public Date getEndSkilling() {
        return endSkilling;
    }

    public void setEndSkilling(Date endSkilling) {
        this.endSkilling = endSkilling;
    }

    public String getSkillPracticalMark() {
        return skillPracticalMark;
    }

    public void setSkillPracticalMark(String skillPracticalMark) {
        this.skillPracticalMark = skillPracticalMark;
    }

    public String getSkillMark() {
        return skillMark;
    }

    public void setSkillMark(String skillMark) {
        this.skillMark = skillMark;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
