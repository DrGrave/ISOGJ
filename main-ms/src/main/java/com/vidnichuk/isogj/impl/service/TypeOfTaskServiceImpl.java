package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.TypeOfTaskRepository;
import com.vidnichuk.isogj.api.entity.TypeOfTask;
import com.vidnichuk.isogj.api.service.TypeOfTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of type of task service
 */
@Service
public class TypeOfTaskServiceImpl implements TypeOfTaskService{
    @Autowired
    private TypeOfTaskRepository typeOfTaskRepository;

    /**
     *
     * @return
     * all types of task
     */
    @Override
    public List<TypeOfTask> getAllTypeOfTask() {
        return typeOfTaskRepository.findAll();
    }

    /**
     *
     * @param idTypeOfTask
     * id type of task
     * @return
     * type of task with this id
     */
    @Override
    public TypeOfTask getTypeOfTaskById(int idTypeOfTask) {
        return typeOfTaskRepository.findByIdTypeOfTask(idTypeOfTask);
    }

    /**
     *
     * @param typeOfTask
     * save type of task
     */
    @Override
    public void saveTypeOfTask(TypeOfTask typeOfTask) {
        typeOfTaskRepository.save(typeOfTask);
    }
}
