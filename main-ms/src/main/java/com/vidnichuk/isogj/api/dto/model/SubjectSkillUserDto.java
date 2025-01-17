package com.vidnichuk.isogj.api.dto.model;


public class SubjectSkillUserDto {
    private Long id;
    private SubjectSkillDto subjectSkill;
    private UserDto expert;
    private int mark;

    public SubjectSkillUserDto(Long id, SubjectSkillDto subjectSkill, UserDto expert, int mark) {
        this.id = id;
        this.subjectSkill = subjectSkill;
        this.expert = expert;
        this.mark = mark;
    }

    public SubjectSkillUserDto() {
    }

    public UserDto getExpert() {
        return expert;
    }

    public void setExpert(UserDto expert) {
        this.expert = expert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubjectSkillDto getSubjectSkill() {
        return subjectSkill;
    }

    public void setSubjectSkill(SubjectSkillDto subjectSkill) {
        this.subjectSkill = subjectSkill;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
