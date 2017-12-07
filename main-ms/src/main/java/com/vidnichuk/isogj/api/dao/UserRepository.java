package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by vadim on 16.10.17.
 * user repository class
 */

public interface UserRepository extends JpaRepository<User, Long>{

    /**
     * @param email
     * email of user
     * @return
     * user with this email
     */
    User findByEmail(String email);

    /**
     *
     * @param id
     * id of user
     * @return
     * user with this id
     */
    User findById(Long id);

    User findByUsername(String username);
}
