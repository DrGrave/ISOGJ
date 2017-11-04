package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.TypeOfSkill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 03.11.2017.
 * type of skill repository
 */
public interface TypeOfSkillRepository extends JpaRepository<TypeOfSkill, Long> {
    /**
     *
     * @param idTypeOfSkill
     * id of type of skill
     * @return
     * type of skill object with this id
     */
    TypeOfSkill findByIdTypeOfSkill(int idTypeOfSkill);


    /**
     *
     * @param nameOfTypeOfSkill
     * name of type of skill
     * @return
     * object type of skill by name
     *
     */
    TypeOfSkill findByNameOfTypeSkill(String nameOfTypeOfSkill);
}
