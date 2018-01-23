package com.vidnichuk.isogj.impl.service.vacancy;

import com.vidnichuk.isogj.api.dao.VacancyRepository;
import com.vidnichuk.isogj.api.dto.mapper.VacancyDtoMapper;
import com.vidnichuk.isogj.api.dto.model.N_A_VacancyDto;
import com.vidnichuk.isogj.api.model.Vacancy;
import com.vidnichuk.isogj.api.service.vacancy.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VacancyServiceImpl implements VacancyService{
    @Autowired
    private VacancyRepository vacancyRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private VacancyDtoMapper vacancyDtoMapper;

    @Override
    public List<N_A_VacancyDto> findAllVacancyDto() {
        List<N_A_VacancyDto> NAVacancyDtos = new ArrayList<>();
        for (Vacancy vacancy : vacancyRepository.findAll()){
            NAVacancyDtos.add(vacancyDtoMapper.fromVacancyToVacancyDTO(vacancy));
        }
        return NAVacancyDtos;
    }
}
