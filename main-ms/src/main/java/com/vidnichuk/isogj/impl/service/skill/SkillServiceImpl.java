package com.vidnichuk.isogj.impl.service.skill;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.*;
import com.vidnichuk.isogj.api.model.type.TypeOfSkill;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService{
    @Autowired
    private UserSkillRepository userSkillRepository;

    @Autowired
    private VacancySkillRepository vacancySkillRepository;

    @Autowired
    private DepartmentSkillRepository departmentSkillRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserSkillDtoMapper userSkillDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DepartmentSkillDtoMapper departmentSkillDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private VacancySkillDtoMapper vacancySkillDtoMapper;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoursesSkillRepository coursesSkillRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CoursesSkillDtoMapper coursesSkillDtoMapper;

    @Autowired
    private PositionSkillRepository positionSkillRepository;

    @Autowired
    private TypeOfSkillRepository typeOfSkillRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SkillDtoMapper skillDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TypeOfSkillDtoMapper typeOfSkillDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PositionSkillDtoMapper positionSkillDtoMapper;

    @Override
    public List<UserSkillDto> findAllSkillsByUserId(String id) {
        List<UserSkillDto> userSkillDtoList = new ArrayList<>();
        for (UserSkill userSkill : userSkillRepository.findAllByUser_Uid(id)){
            userSkillDtoList.add(userSkillDtoMapper.fromUserSkillToUserSkillDto(userSkill));
        }
        return userSkillDtoList;
    }

    @Override
    public List<VacancySkillDto> findAllSkillsByVacancyId(long id) {
        List<VacancySkillDto> vacancySkillDtoList = new ArrayList<>();
        for (VacancySkill vacancySkill : vacancySkillRepository.findAllByVacancy_Id(id)){
            vacancySkillDtoList.add(vacancySkillDtoMapper.fromVacancySkillToVacancySkillDto(vacancySkill));
        }
        return vacancySkillDtoList;
    }



    @Override
    public List<UserSkillDto> findAuthorizedSkillsByUserId(String id) {
        List<UserSkillDto> userSkillDtoList = new ArrayList<>();
        for (UserSkill userSkill : userSkillRepository.findAllByUser_Uid(id)){
            userSkillDtoList.add(userSkillDtoMapper.fromUserSkillToUserSkillDto(userSkill));
        }
        return userSkillDtoList;
    }

    @Override
    public List<SkillDto> findAddSkill(String name) {
        List<Skill> skills = skillRepository.findAllByNameContains(name);
        List<SkillDto> skillDtos = new ArrayList<>();
        if (skills.size() > 6){
            skills = skills.subList(0,5);
        }
        for (Skill skill : skills){
            skillDtos.add(skillDtoMapper.fromSkillToSkillDtoMapper(skill));
        }
        return skillDtos;
    }

    @Override
    public List<UserSkillDto> addAndGetSkillsToUser(SkillDto skill, String id) {
        if (userSkillRepository.findByUserUidAndSkillId(id, skill.getId()) == null) {
            UserSkill userSkill = new UserSkill();
            userSkill.setSkill(skillRepository.findSkillById(skill.getId()));
            userSkill.setUser(userRepository.findByUid(id));
            userSkillRepository.save(userSkill);
        }
        List<UserSkillDto> userSkillDtoList = new ArrayList<>();
        for (UserSkill thisSkill: userSkillRepository.findAllByUser_Uid(id)){
            userSkillDtoList.add(userSkillDtoMapper.fromUserSkillToUserSkillDto(thisSkill));
        }
        return userSkillDtoList;
    }

    @Override
    public List<TypeOfSkillDto> getAllTypesOfSkill() {
        List<TypeOfSkillDto> typeOfSkillDtos = new ArrayList<>();
        for (TypeOfSkill typeOfSkill: typeOfSkillRepository.findAll()){
            typeOfSkillDtos.add(typeOfSkillDtoMapper.fromTypeOfSkillToTypeOfSkillDto(typeOfSkill));
        }
        return typeOfSkillDtos;
    }

    @Override
    public void addNewSkill(SkillDto skill) {
        skillRepository.save(skillDtoMapper.fromSkillDtoToSkillMapper(skill));
    }

    @Override
    public List<UserSkillDto> deleteSkills(UserSkillDto userSkillDto, String id) {
        List<UserSkillDto> userSkillDtoList = new ArrayList<>();
        userSkillRepository.delete(userSkillDto.getId());
        for (UserSkill userSkill : userSkillRepository.findAllByUser_Uid(id)){
            userSkillDtoList.add(userSkillDtoMapper.fromUserSkillToUserSkillDto(userSkill));
        }
        return userSkillDtoList;
    }

    @Override
    public List<PositionSkillDto> getPositionSkills(long id) {
        List<PositionSkillDto> positionSkillDtoList = new ArrayList<>();
        for (PositionSkill positionSkill: positionSkillRepository.findAllByPositionId(id)){
            positionSkillDtoList.add(positionSkillDtoMapper.fromPositionToPositionDto(positionSkill));
        }
        return positionSkillDtoList;
    }

    @Override
    public List<DepartmentSkillDto> getDepartmentSkills(long id) {
        List<DepartmentSkillDto> departmentSkillDtos = new ArrayList<>();
        for (DepartmentSkill departmentSkill: departmentSkillRepository.findAllByDepartmentId(id)){
            departmentSkillDtos.add(departmentSkillDtoMapper.fromDepartmentSkillToDepartmentSkillDto(departmentSkill));
        }
        return departmentSkillDtos;
    }

    @Override
    public List<CoursesSkillDto> getAllCoursesSkill(Long id) {
        List<CoursesSkillDto> coursesSkillDtoList = new ArrayList<>();
        for (CoursesSkill coursesSkill: coursesSkillRepository.findAllByCoursesId(id)){
            coursesSkillDtoList.add(coursesSkillDtoMapper.fromCoursesSkillToCoursesSkillDto(coursesSkill));
        }
        return coursesSkillDtoList;
    }
}
