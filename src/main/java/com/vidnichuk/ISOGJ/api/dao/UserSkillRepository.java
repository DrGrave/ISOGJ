package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vadim on 03.11.2017.
 * user skill repository
 */
public interface UserSkillRepository extends JpaRepository<UserSkill,Long>{
    /**
     *
     * @param idUser
     * id of user
     * @return
     * list of skills witch have such id
     */
    List<UserSkill> findAllByIdUser_UserId(int idUser);
}
