package com.vidnichuk.isogj.api.dto.model;



import java.util.List;

public class UserListInfoDto {
    private UserDto userDto;
    private UserLinkDto userLinkDto;
    private List<UserSkillDto> userSkills;
    private List<N_A_EducationDto> educations;

    public UserListInfoDto(UserDto userDto, UserLinkDto userLinkDto, List<UserSkillDto> userSkills, List<N_A_EducationDto> educations) {
        this.userDto = userDto;
        this.userLinkDto = userLinkDto;
        this.userSkills = userSkills;
        this.educations = educations;
    }

    public UserListInfoDto(){}

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<UserSkillDto> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<UserSkillDto> userSkills) {
        this.userSkills = userSkills;
    }

    public List<N_A_EducationDto> getEducations() {
        return educations;
    }

    public void setEducations(List<N_A_EducationDto> educations) {
        this.educations = educations;
    }

    public UserLinkDto getUserLinkDto() {
        return userLinkDto;
    }

    public void setUserLinkDto(UserLinkDto userLinkDto) {
        this.userLinkDto = userLinkDto;
    }
}
