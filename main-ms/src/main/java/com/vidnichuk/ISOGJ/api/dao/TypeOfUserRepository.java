package com.vidnichuk.ISOGJ.api.dao;


import com.vidnichuk.ISOGJ.api.entity.TypeOfUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfUserRepository extends JpaRepository<TypeOfUser, Long>{

    /**
     *
     * @param TypeOfUser
     * index of type of user
     * @return
     * object type of user with id
     */
    TypeOfUser findByIdTypeOfUser(int TypeOfUser);
}
