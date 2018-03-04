package com.vidnichuk.isogj.impl.service.courses;

import com.vidnichuk.isogj.api.dao.UserCoursesRepository;
import com.vidnichuk.isogj.api.dto.mapper.UserCoursesDtoMapper;
import com.vidnichuk.isogj.api.dto.model.CoursesSkillDto;
import com.vidnichuk.isogj.api.dto.model.CoursesSkillsListDto;
import com.vidnichuk.isogj.api.model.UserCourses;
import com.vidnichuk.isogj.api.service.courses.CoursesService;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService{
    @Autowired
    private UserCoursesRepository userCoursesRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserCoursesDtoMapper userCoursesDtoMapper;

    @Autowired
    private SkillService skillService;

    @Override
    public List<CoursesSkillsListDto> getCoursesByUserId(Long id) {
        try {
            List<CoursesSkillsListDto> coursesSkillsListDtos = new ArrayList<>();
            for (UserCourses userCourses : userCoursesRepository.findAllByUser_Id(id)) {
                coursesSkillsListDtos.add(new CoursesSkillsListDto(userCoursesDtoMapper.fromUserCoursesToUserCoursesDto(userCourses), skillService.getAllCoursesSkill(userCourses.getCourses().getId())));
            }
            return coursesSkillsListDtos;
        }catch (NullPointerException ex){
            return null;
        }
    }

    @Override
    public CoursesSkillsListDto getOneByUserCoursesId(Long id) {
        try {
            CoursesSkillsListDto coursesSkillsListDto = new CoursesSkillsListDto();
            coursesSkillsListDto.setUserCoursesDto(userCoursesDtoMapper.fromUserCoursesToUserCoursesDto(userCoursesRepository.findById(id)));
            coursesSkillsListDto.setCoursesSkillDtoList(skillService.getAllCoursesSkill(userCoursesRepository.findById(id).getCourses().getId()));
            return coursesSkillsListDto;
        }catch (NullPointerException ex){
            return null;
        }
    }
}
