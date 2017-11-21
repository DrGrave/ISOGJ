package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.User;
import com.vidnichuk.isogj.api.entity.UserSkill;
import com.vidnichuk.isogj.api.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/UserSkill")
public class UserSkillController {
    @Autowired
    private UserSkillService userSkillService;

    @GetMapping("/{id}")
    public ResponseEntity<List<UserSkill>> getUserSkillsByIdUser(@PathVariable("id") Integer id){
        List<UserSkill> userSkills = userSkillService.getUserSkillsByUserId(id);
        if (userSkills != null){
            return new ResponseEntity<List<UserSkill>>(userSkills, HttpStatus.OK);
        }return new ResponseEntity<List<UserSkill>>(HttpStatus.NOT_FOUND);
    }
}
