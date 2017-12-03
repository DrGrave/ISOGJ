package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.VacancyDTO;
import com.vidnichuk.isogj.api.entity.TypeOfVacancy;
import com.vidnichuk.isogj.api.entity.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class VacancyMapperImpl implements VacancyMapper{

    @Override
    public VacancyDTO fromVacancyToVacancyDTO(Vacancy vacancy) {
        if ( vacancy == null ) {
            return null;
        }
        VacancyDTO vacancyDTO = new VacancyDTO();
        vacancyDTO.setIdVacancy(vacancy.getIdVacancy());
        vacancyDTO.setInfoOfVacancy(vacancy.getInfoOfVacancy());
        vacancyDTO.setTypeOfVacancy(vacancy.getTypeOfVacancy().getNameTypeOfVacancy());
        return vacancyDTO;
    }

    @Override
    public Vacancy fromVacancyDtoToVacancy(VacancyDTO vacancyDTO) {
        if ( vacancyDTO == null ) {
            return null;
        }
        Vacancy vacancy = new Vacancy();
        vacancy.setIdVacancy(vacancyDTO.getIdVacancy());
        vacancy.setInfoOfVacancy(vacancyDTO.getInfoOfVacancy());
        TypeOfVacancy typeOfVacancy = new TypeOfVacancy();
        typeOfVacancy.setNameTypeOfVacancy(vacancyDTO.getTypeOfVacancy());
        vacancy.setTypeOfVacancy(typeOfVacancy);
        return vacancy;
    }

    @Override
    public List<Vacancy> fromListOfVacancyDTOToListOfVacancy(List<VacancyDTO> vacancyDTOList) {
        if (vacancyDTOList == null){
            return null;
        }else {
            List<Vacancy> vacancyList = new ArrayList<>();
            for (VacancyDTO vacancyDTO : vacancyDTOList){
                vacancyList.add(fromVacancyDtoToVacancy(vacancyDTO));
            }
            return vacancyList;
        }
    }

    @Override
    public List<VacancyDTO> fromListOfVacancyToListOfVacancyDTO(List<Vacancy> vacancyList) {
        if (vacancyList == null){
            return null;
        }else {
            List<VacancyDTO> vacancyDTOList = new ArrayList<>();
            for (Vacancy vacancy : vacancyList){
                vacancyDTOList.add(fromVacancyToVacancyDTO(vacancy));
            }
            return vacancyDTOList;
        }
    }
}
