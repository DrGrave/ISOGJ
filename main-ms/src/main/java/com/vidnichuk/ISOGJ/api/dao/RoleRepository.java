package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by vadim on 16.10.17.
 * repository to roles
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

    /**
     *
     * @param role
     * role of user
     * @return
     * role of user
     */
    Role findByRole(String role);
}
