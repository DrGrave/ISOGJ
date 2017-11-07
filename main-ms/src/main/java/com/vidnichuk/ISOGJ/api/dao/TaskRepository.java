package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to task entity
 */
public interface TaskRepository extends JpaRepository<Task, Long>{
    /**
     *
     * @param idOfTask
     * id of task
     * @return
     * task with this id
     */
    Task findByIdOfTask(int idOfTask);
}