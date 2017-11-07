package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.Task;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to task repository
 */
public interface TaskService {
    List<Task> getAllTask();
    Task getByIdTask(int idTask);
    void saveTask(Task task);
}
