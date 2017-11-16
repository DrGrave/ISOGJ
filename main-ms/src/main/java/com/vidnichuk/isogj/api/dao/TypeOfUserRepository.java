package com.vidnichuk.isogj.api.dao;


import com.vidnichuk.isogj.api.entity.TypeOfUser;
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
