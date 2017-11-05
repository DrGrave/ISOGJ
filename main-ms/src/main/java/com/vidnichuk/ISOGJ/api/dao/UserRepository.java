package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by vadim on 16.10.17.
 * user repository class
 */

public interface UserRepository extends JpaRepository<User, Long>{

    /**
     *
     * @param userEmail
     * email of user
     * @return
     * user with this email
     */
    User findByUserEmail(String userEmail);
}
