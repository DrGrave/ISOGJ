package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.Task;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to task repository
 */
public interface TaskService {
    /**
     *
     * @return
     * all tasks
     */
    List<Task> getAllTask();

    /**
     *
     * @param idTask
     * id of task
     * @return
     * task with this id
     */
    Task getByIdTask(int idTask);

    /**
     *
     * @param task
     * save task
     */
    void saveTask(Task task);
}
