package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.TypeOfTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to type of task entity
 */
public interface TypeOfTaskRepository extends JpaRepository<TypeOfTask, Long>{
    TypeOfTask findByIdTypeOfTask(int idTypeOfTask);
}
