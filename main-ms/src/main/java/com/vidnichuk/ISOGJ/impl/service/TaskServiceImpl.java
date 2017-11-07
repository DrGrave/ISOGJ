package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.TaskRepository;
import com.vidnichuk.ISOGJ.api.entity.Task;
import com.vidnichuk.ISOGJ.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of task service
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getByIdTask(int idTask) {
        return taskRepository.findByIdOfTask(idTask);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
