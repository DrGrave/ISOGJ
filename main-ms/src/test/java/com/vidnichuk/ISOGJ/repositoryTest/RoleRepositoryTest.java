package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.RoleRepository;
import com.vidnichuk.ISOGJ.api.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by vadim on 16.10.17.
 * test to role repository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void contextLoads() {
    }

    /**
     * try to save role to db
     */
    @Test
    public void saveRole(){
        Role role = new Role();
        role.setRole("ADMIN");
        roleRepository.save(role);
    }

    /**
     * try to get role from db
     */
    @Test
    public void getRoleByRole(){
        Role role = roleRepository.findAll().get(0);
        System.out.println(role);
    }
}
