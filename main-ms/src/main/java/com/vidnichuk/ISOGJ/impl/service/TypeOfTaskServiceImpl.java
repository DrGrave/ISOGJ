package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.TypeOfTaskRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfTask;
import com.vidnichuk.ISOGJ.api.service.TypeOfTaskService;
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

    @Override
    public List<TypeOfTask> getAllTypeOfTask() {
        return typeOfTaskRepository.findAll();
    }

    @Override
    public TypeOfTask getTypeOfTaskById(int idTypeOfTask) {
        return typeOfTaskRepository.findByIdTypeOfTask(idTypeOfTask);
    }

    @Override
    public void saveTypeOfTask(TypeOfTask typeOfTask) {
        typeOfTaskRepository.save(typeOfTask);
    }
}
