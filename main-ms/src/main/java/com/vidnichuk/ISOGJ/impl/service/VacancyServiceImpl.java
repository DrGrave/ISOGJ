package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.VacancyRepository;
import com.vidnichuk.ISOGJ.api.entity.Vacancy;
import com.vidnichuk.ISOGJ.api.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of vacancy service
 */

@Service
public class VacancyServiceImpl implements VacancyService{
    @Autowired
    private VacancyRepository vacancyRepository;

    /**
     *
     * @return
     * all vacancy
     */
    @Override
    public List<Vacancy> getAllVacancy() {
        return vacancyRepository.findAll();
    }

    /**
     *
     * @param idVacancy
     * id of vacancy
     * @return
     * vacancy with this id
     */
    @Override
    public Vacancy getById(int idVacancy) {
        return vacancyRepository.findByIdVacancy(idVacancy);
    }

    /**
     *
     * @param vacancy
     * save vacancy
     */
    @Override
    public void saveVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }
}
