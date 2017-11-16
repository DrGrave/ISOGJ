package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.TypeOfSkillRepository;
import com.vidnichuk.isogj.api.entity.TypeOfSkill;
import com.vidnichuk.isogj.api.service.TypeOfSkillService;
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

    /**
     *
     * @return
     * all types of skill
     */
    @Override
    public List<TypeOfSkill> getAllTypeOfSlills() {
        return typeOfSkillRepository.findAll();
    }

    /**
     *
     * @param idTypeOfSkill
     * id type of skill
     * @return
     * type of skill with this id
     */
    @Override
    public TypeOfSkill getTypeOfSkillById(int idTypeOfSkill) {
        return typeOfSkillRepository.findByIdTypeOfSkill(idTypeOfSkill);
    }

    /**
     *
     * @param typeOfSkill
     * save type of skill
     */
    @Override
    public void saveTypeOfSkill(TypeOfSkill typeOfSkill) {
        typeOfSkillRepository.save(typeOfSkill);
    }
}
