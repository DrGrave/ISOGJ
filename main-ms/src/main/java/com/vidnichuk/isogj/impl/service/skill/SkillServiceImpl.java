package com.vidnichuk.isogj.impl.service.skill;

import com.vidnichuk.isogj.api.dao.UserSkillRepository;
import com.vidnichuk.isogj.api.dto.mapper.UserSkillDtoMapper;
import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.model.UserSkill;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService{
    @Autowired
    private UserSkillRepository userSkillRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserSkillDtoMapper userSkillDtoMapper;

    @Override
    public List<UserSkillDto> findAllSkillsByUserId(long id) {
        List<UserSkillDto> userSkillDtoList = new ArrayList<>();
        for (UserSkill userSkill : userSkillRepository.findAllByUser_Id(id)){
            userSkillDtoList.add(userSkillDtoMapper.fromUserSkillToUserSkillDto(userSkill));
        }
        return userSkillDtoList;
    }
}
