package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.Department;
import com.vidnichuk.isogj.api.model.School;
import com.vidnichuk.isogj.api.model.type.TypeOfEducation;

public class N_A_EducationDto {
    private Long id;
    private TypeOfEducation typeOfEducation;
    private Department department;
    private School school;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOfEducation getTypeOfEducation() {
        return typeOfEducation;
    }

    public void setTypeOfEducation(TypeOfEducation typeOfEducation) {
        this.typeOfEducation = typeOfEducation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
