package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.TypeOfTask;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of task repository
 */
public interface TypeOfTaskService {

    /**
     *
     * @return
     * get all types of task
     */
    List<TypeOfTask> getAllTypeOfTask();

    /**
     *
     * @param idTypeOfTask
     * id type of task
     * @return
     * type of task with this id
     */
    TypeOfTask getTypeOfTaskById(int idTypeOfTask);

    /**
     *
     * @param typeOfTask
     * save type of task
     */
    void saveTypeOfTask(TypeOfTask typeOfTask);
}
