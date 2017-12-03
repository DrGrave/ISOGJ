package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.VacancyRepository;
import com.vidnichuk.isogj.api.dto.VacancyDTO;
import com.vidnichuk.isogj.api.entity.Vacancy;
import com.vidnichuk.isogj.api.mappers.VacancyMapper;
import com.vidnichuk.isogj.api.service.VacancyService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of vacancy service
 */

@Service
public class VacancyServiceImpl implements VacancyService{

    private VacancyMapper vacancyMapper = Mappers.getMapper(VacancyMapper.class);
    @Autowired
    private VacancyRepository vacancyRepository;

    /**
     *
     * @return
     * all vacancy
     */
    @Override
    public List<VacancyDTO> getAllVacancy() {
        return vacancyMapper.fromListOfVacancyToListOfVacancyDTO(vacancyRepository.findAll());
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
