package com.vidnichuk.isogj.impl.service.history;

import com.vidnichuk.isogj.api.dao.HistoryRepository;
import com.vidnichuk.isogj.api.dto.mapper.HistoryDtoMapper;
import com.vidnichuk.isogj.api.dto.model.HistorySkillsDto;
import com.vidnichuk.isogj.api.model.History;
import com.vidnichuk.isogj.api.service.courses.CoursesService;
import com.vidnichuk.isogj.api.service.education.EducationService;
import com.vidnichuk.isogj.api.service.experience.ExperienceService;
import com.vidnichuk.isogj.api.service.history.HistoryService;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private SkillService skillService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private CoursesService coursesService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private HistoryDtoMapper historyDtoMapper;

    @Override
    public List<HistorySkillsDto> getAllUserHistory(Long id, Pageable pageable) {
        try {
            List<HistorySkillsDto> historySkillsDtoList = new ArrayList<>();
            for (History history : historyRepository.findAllByUser_Id(id, pageable)) {
                HistorySkillsDto historySkillsDto = new HistorySkillsDto();
                historySkillsDto.setHistoryDto(historyDtoMapper.fromHistoryToHistoryDto(history));
                if (coursesService.getOneByUserCoursesId(history.getUserCourses().getId()) != null) {
                    historySkillsDto.setCoursesSkillDto(coursesService.getOneByUserCoursesId(history.getUserCourses().getId()));
                }else if (educationService.getOneEducationById(history.getEducation().getId()) != null) {
                    historySkillsDto.setEducationSkillsDto(educationService.getOneEducationById(history.getEducation().getId()));
                }else if (experienceService.getOneByExperienceId(history.getExperience().getId()) != null) {
                    historySkillsDto.setExperienceSkillsDto(experienceService.getOneByExperienceId(history.getExperience().getId()));
                }
                historySkillsDtoList.add(historySkillsDto);
            }
            return historySkillsDtoList;
        }catch (NullPointerException ex){
            return null;
        }
    }

    @Override
    public long getCountOfHistory(Long id) {
        return historyRepository.countAllByUserId(id);
    }
}
