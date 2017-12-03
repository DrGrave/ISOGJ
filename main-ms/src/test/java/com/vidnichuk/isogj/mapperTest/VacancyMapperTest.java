package com.vidnichuk.isogj.mapperTest;

import com.vidnichuk.isogj.api.dto.VacancyDTO;
import com.vidnichuk.isogj.api.entity.Vacancy;
import com.vidnichuk.isogj.api.mappers.VacancyMapper;
import com.vidnichuk.isogj.api.service.VacancyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class VacancyMapperTest {
    private VacancyMapper vacancyMapper = Mappers.getMapper(VacancyMapper.class);

    @Autowired
    VacancyService vacancyService;

    @Test
    public void fromVacancyToVacancyDTO(){
        Vacancy vacancy = vacancyService.getById(1);
        VacancyDTO vacancyDTO = vacancyMapper.fromVacancyToVacancyDTO(vacancy);
        System.out.print(vacancyDTO);
    }

    @Test
    public void fromVacancyDTOToVacancy(){
        Vacancy vacancy = vacancyService.getById(1);
        VacancyDTO vacancyDTO = vacancyMapper.fromVacancyToVacancyDTO(vacancy);
        Vacancy vacancy1 = vacancyMapper.fromVacancyDtoToVacancy(vacancyDTO);
        System.out.print(vacancy1);
    }
}
