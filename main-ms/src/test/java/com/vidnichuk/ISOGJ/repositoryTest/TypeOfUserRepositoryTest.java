package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.TypeOfUserRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test of type user repository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeOfUserRepositoryTest {
    @Autowired
    private TypeOfUserRepository typeOfUserRepository;



    @Test
    public void saveTypeOfUser(){
        TypeOfUser typeOfUser = new TypeOfUser();
        typeOfUser.setNameOfTypeUser("Worker");
        typeOfUserRepository.save(typeOfUser);
    }

    @Test
    public void findTypeOfUser(){
        TypeOfUser typeOfUser = typeOfUserRepository.findAll().get(0);
        typeOfUser.getNameOfTypeUser();
    }

}
