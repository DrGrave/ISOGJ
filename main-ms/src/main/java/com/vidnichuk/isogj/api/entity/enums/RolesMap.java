package com.vidnichuk.isogj.api.entity.enums;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vadim on 20.06.2017.
 * roles to user
 */
public class RolesMap {
    private Map<Integer, String> roles = new HashMap<>();

    public Map<Integer, String> getRoles() {
        roles.put(1, "ROLE_USER");
        roles.put(2, "ROLE_USER");
        roles.put(3, "ROLE_ADMIN");
        roles.put(4, "DBA");
        return roles;
    }

    public void setRoles(Map<Integer, String> roles) {
        this.roles = roles;
    }

    public String getRole(int i){

        return roles.get(i);
    }
}