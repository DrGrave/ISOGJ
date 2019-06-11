package com.vidnichuk.isogj.api.dto.model;

public class SubjectSkillDto {
    private Long id;
    private SubjectDto subjectDto;
    private int percentOfSkill;
    private int percentOfSubject;
    private SkillDto skillDto;

    public SubjectSkillDto(Long id, SubjectDto subjectDto, int percentOfSkill, int persentOfSubject, SkillDto skillDto) {
        this.id = id;
        this.subjectDto = subjectDto;
        this.percentOfSkill = percentOfSkill;
        this.percentOfSubject = persentOfSubject;
        this.skillDto = skillDto;
    }

    public SubjectSkillDto() {
    }


    public int getPersentOfSkill() {
        return percentOfSkill;
    }

    public void setPersentOfSkill(int persentOfSkill) {
        this.percentOfSkill = persentOfSkill;
    }

    public int getPersentOfSubject() {
        return percentOfSubject;
    }

    public void setPersentOfSubject(int persentOfSubject) {
        this.percentOfSubject = persentOfSubject;
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
