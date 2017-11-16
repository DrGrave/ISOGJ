package com.vidnichuk.isogj.impl.service;


import com.vidnichuk.isogj.api.entity.MyUserCredentials;
import com.vidnichuk.isogj.api.entity.enums.RolesMap;
import com.vidnichuk.isogj.api.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserCredentialsService userCredentialsService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUserCredentials userCredentials = userCredentialsService.getUserByLogin(s);
        RolesMap rolesMap = new RolesMap();
        rolesMap.getRoles();
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(rolesMap.getRole(userCredentials.getUser().getTypeOfUser().getIdTypeOfUser())));
        return new org.springframework.security.core.userdetails.User(userCredentials.getUserLogin(), userCredentials.getUserPassword(), roles);
    }
}
