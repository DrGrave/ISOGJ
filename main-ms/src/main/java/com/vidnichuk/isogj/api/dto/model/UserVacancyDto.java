package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.User;

public class UserVacancyDto {
    private Long id;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
