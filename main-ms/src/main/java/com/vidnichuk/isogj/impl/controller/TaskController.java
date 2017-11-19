package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.entity.Task;
import com.vidnichuk.isogj.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * request
     * /Task/
     * @return
     * all tasks
     */
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> taskList = taskService.getAllTask();
        if (taskList != null){
            return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
        } return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
    }
}
