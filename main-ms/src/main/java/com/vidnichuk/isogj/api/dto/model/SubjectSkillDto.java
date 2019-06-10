package com.vidnichuk.isogj.api.dto.model;

public class SubjectSkillDto {
    private Long id;
    private SubjectDto subjectDto;
    private SkillDto skillDto;

    public SubjectSkillDto(Long id, SubjectDto subjectDto, SkillDto skillDto) {
        this.id = id;
        this.subjectDto = subjectDto;
        this.skillDto = skillDto;
    }

    public SubjectSkillDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubjectDto getSubjectDto() {
        return subjectDto;
    }

    public void setSubjectDto(SubjectDto subjectDto) {
        this.subjectDto = subjectDto;
    }

    public SkillDto getSkillDto() {
        return skillDto;
    }

    public void setSkillDto(SkillDto skillDto) {
        this.skillDto = skillDto;
    }
}
