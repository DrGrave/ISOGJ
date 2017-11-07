package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.CityRepository;
import com.vidnichuk.ISOGJ.api.dao.CompanyRepository;
import com.vidnichuk.ISOGJ.api.entity.City;
import com.vidnichuk.ISOGJ.api.entity.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Vadim on 07.11.2017.
 * test to company repository
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CityRepository cityRepository;

    /**
     * try to save company
     */
    @Test
    public void saveCompany(){
        City city = new City();
        city.setNameOfCity("Minsk");
        cityRepository.save(city);
        Company company = new Company();
        company.setCityOfCompany(cityRepository.findAll().get(0));
        company.setInfoOfCompany("dfdsfsd");
        company.setDateOfCreationCompany(Date.valueOf(LocalDate.now()));
        company.setNameOfCompany("fasfdasd");
        companyRepository.save(company);
    }

    /**
     * try to find company
     */
    @Test
    public void findCompanyById(){
        City city = new City();
        city.setNameOfCity("Minsk");
        cityRepository.save(city);
        Company company = new Company();
        company.setCityOfCompany(cityRepository.findAll().get(0));
        company.setInfoOfCompany("dfdsfsd");
        company.setDateOfCreationCompany(Date.valueOf(LocalDate.now()));
        company.setNameOfCompany("fasfdasd");
        companyRepository.save(company);

        companyRepository.findByIdCompany(companyRepository.findAll().get(0).getIdOfCompany()).getInfoOfCompany();
    }

    /**
     * find all company's
     */
    @Test
    public void findCompanys(){
        City city = new City();
        city.setNameOfCity("Minsk");
        cityRepository.save(city);
        Company company = new Company();
        company.setCityOfCompany(cityRepository.findAll().get(0));
        company.setInfoOfCompany("dfdsfsd");
        company.setDateOfCreationCompany(Date.valueOf(LocalDate.now()));
        company.setNameOfCompany("fasfdasd");
        companyRepository.save(company);

        companyRepository.findAll().get(0).getNameOfCompany();
    }
}
