package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.EducationRepository;
import com.vidnichuk.ISOGJ.api.entity.Education;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by Vadim on 07.11.2017.
 * test to education repository
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EducationRepositoryTest {
    @Autowired
    private EducationRepository educationRepository;

    @Test
    public void saveEducation(){
        Education education = new Education();
    }
}
