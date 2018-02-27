package com.vidnichuk.isogj.impl.service.vacancy;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.*;
import com.vidnichuk.isogj.api.service.vacancy.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VacancyServiceImpl implements VacancyService{
    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private UserVacancyRepository userVacancyRepository;

    @Autowired
    private TaskSkillRepository taskSkillRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TaskSkillDtoMapper taskSkillDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserVacancyDtoMapper userVacancyDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private VacancyTaskRepository vacancyTaskRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private VacancyTaskDtoMapper vacancyTaskDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private VacancyDtoMapper vacancyDtoMapper;

    @Override
    public List<N_A_VacancyDto> findAllVacancyDto(int page, int size) {
        List<N_A_VacancyDto> NAVacancyDtos = new ArrayList<>();
        for (Vacancy vacancy : vacancyRepository.findAll(createPageRequest(size,page))){
            NAVacancyDtos.add(vacancyDtoMapper.fromVacancyToVacancyDTO(vacancy));
        }
        return NAVacancyDtos;
    }

    @Override
    public List<UserDto> getUserByCompanyId(long id, boolean us, boolean comp) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (VacancyUser vacancyUser: userVacancyRepository.findAllByVacancyIdAndIfAcceptedUserAndIfCompanyAccepted(id, us, comp)){
            userDtoList.add(userDtoMapper.fromUserToUserDto(vacancyUser.getUser()));
        }
        return userDtoList;
    }

    @Override
    public List<VacancyDto> getVacancyByCompanyId(long id) {
        List<VacancyDto> vacancyDtos = new ArrayList<>();
        for (Vacancy vacancy: vacancyRepository.findAllByCompanyId(id)){
            vacancyDtos.add(vacancyDtoMapper.fromVacancyToVacancyDto(vacancy));
        }
        return vacancyDtos;
    }

    @Override
    public List<VacancyTaskDto> getTasksByVacancyId(long id) {
        List<VacancyTaskDto> taskDtos = new ArrayList<>();
        for (VacancyTask vacancyTask: vacancyTaskRepository.findAllByVacancyId(id)){
            taskDtos.add(vacancyTaskDtoMapper.fromVacancyTaskToVacancyTaskDto(vacancyTask));
        }
        return taskDtos;
    }

    @Override
    public List<TaskSkillDto> getSkillsToTask(long id) {
        List<TaskSkillDto> skillDtoList = new ArrayList<>();
        for (TaskSkill skill: taskSkillRepository.findAllByTask_Id(id)){
            skillDtoList.add(taskSkillDtoMapper.fromTaskSkillToTaskSkillDto(skill));
        }
        return skillDtoList;
    }

    @Override
    public long getCountOfVacancy() {
        return vacancyRepository.count();
    }

    private Pageable createPageRequest(int size, int page) {
        return new PageRequest(page, size);
    }
}
