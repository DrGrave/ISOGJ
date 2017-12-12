package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.Role;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class UserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private List<String> authorities;

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
