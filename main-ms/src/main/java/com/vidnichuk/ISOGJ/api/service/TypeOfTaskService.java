package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.TypeOfTask;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of task repository
 */
public interface TypeOfTaskService {
    List<TypeOfTask> getAllTypeOfTask();
    TypeOfTask getTypeOfTaskById(int idTypeOfTask);
    void saveTypeOfTask(TypeOfTask typeOfTask);
}
