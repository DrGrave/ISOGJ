package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.TypeOfSkill;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of skill repository
 */
public interface TypeOfSkillService {

    /**
     *
     * @return
     * all type of skills
     */
    List<TypeOfSkill> getAllTypeOfSlills();

    /**
     *
     * @param idTypeOfSkill
     * id type of skill
     * @return
     * type of skill with this id
     */
    TypeOfSkill getTypeOfSkillById(int idTypeOfSkill);

    /**
     *
     * @param typeOfSkill
     * save type of skill
     */
    void saveTypeOfSkill(TypeOfSkill typeOfSkill);
}
