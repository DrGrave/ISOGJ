package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.dto.model.FacultyDto;
import com.vidnichuk.isogj.api.dto.model.UniversityDto;
import com.vidnichuk.isogj.api.model.Faculty;
import com.vidnichuk.isogj.api.service.faculty.FacultyLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {

    @Autowired
    private FacultyLightWeightService facultyLightWeightService;

    @PostMapping()
    public List<FacultyDto> findFacultysByPartNameAndUniversity(@Valid @RequestBody UniversityDto universityDto, @RequestParam("name") String name){
        return facultyLightWeightService.findFacultysByPartNameAndUniversity(name, universityDto);
    }
}
