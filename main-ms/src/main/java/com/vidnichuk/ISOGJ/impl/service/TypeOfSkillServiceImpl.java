package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.TypeOfSkillRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfSkill;
import com.vidnichuk.ISOGJ.api.service.TypeOfSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of type of skill service
 */
@Service
public class TypeOfSkillServiceImpl implements TypeOfSkillService{
    @Autowired
    private TypeOfSkillRepository typeOfSkillRepository;

    @Override
    public List<TypeOfSkill> getAllTypeOfSlills() {
        return typeOfSkillRepository.findAll();
    }

    @Override
    public TypeOfSkill getTypeOfSkillById(int idTypeOfSkill) {
        return typeOfSkillRepository.findByIdTypeOfSkill(idTypeOfSkill);
    }

    @Override
    public void saveTypeOfSkill(TypeOfSkill typeOfSkill) {
        typeOfSkillRepository.save(typeOfSkill);
    }
}
