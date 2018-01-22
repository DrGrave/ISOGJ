package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.Department;
import com.vidnichuk.isogj.api.model.School;
import com.vidnichuk.isogj.api.model.type.TypeOfEducation;

public class N_A_EducationDto {
    private Long id;
    private TypeOfEducationDto typeOfEducation;
    private DepartmentDto department;
    private School school;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOfEducationDto getTypeOfEducation() {
        return typeOfEducation;
    }

    public void setTypeOfEducation(TypeOfEducationDto typeOfEducation) {
        this.typeOfEducation = typeOfEducation;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
