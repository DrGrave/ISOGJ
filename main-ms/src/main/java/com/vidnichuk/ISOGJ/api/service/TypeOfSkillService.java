package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.TypeOfSkill;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of skill repository
 */
public interface TypeOfSkillService {
    List<TypeOfSkill> getAllTypeOfSlills();
    TypeOfSkill getTypeOfSkillById(int idTypeOfSkill);
    void saveTypeOfSkill(TypeOfSkill typeOfSkill);
}
