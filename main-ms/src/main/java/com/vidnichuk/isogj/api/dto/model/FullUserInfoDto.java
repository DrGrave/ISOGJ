package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class FullUserInfoDto {
    private MeUserDto meUserDto;
    private UserLinkDto userLinkDto;
    private List<EducationDto> educationDtoList;
    private List<UserSkillDto> userSkillDtoList;
    private List<UserCompanyDto> userCompanyDtoList;
    private List<UserLinkDto> userLinkDtoList;

    public FullUserInfoDto(MeUserDto meUserDto, List<EducationDto> educationDtoList, List<UserSkillDto> userSkillDtoList, List<UserCompanyDto> userCompanyDtoList, List<UserLinkDto> userLinkDtoList) {
        this.meUserDto = meUserDto;
        this.educationDtoList = educationDtoList;
        this.userSkillDtoList = userSkillDtoList;
        this.userCompanyDtoList = userCompanyDtoList;
        this.userLinkDtoList = userLinkDtoList;
    }

    public FullUserInfoDto() {
    }

    public UserLinkDto getUserLinkDto() {
        return userLinkDto;
    }

    public void setUserLinkDto(UserLinkDto userLinkDto) {
        this.userLinkDto = userLinkDto;
    }

    public MeUserDto getMeUserDto() {
        return meUserDto;
    }

    public void setMeUserDto(MeUserDto meUserDto) {
        this.meUserDto = meUserDto;
    }

    public List<EducationDto> getEducationDtoList() {
        return educationDtoList;
    }

    public void setEducationDtoList(List<EducationDto> educationDtoList) {
        this.educationDtoList = educationDtoList;
    }

    public List<UserSkillDto> getUserSkillDtoList() {
        return userSkillDtoList;
    }

    public void setUserSkillDtoList(List<UserSkillDto> userSkillDtoList) {
        this.userSkillDtoList = userSkillDtoList;
    }

    public List<UserCompanyDto> getUserCompanyDtoList() {
        return userCompanyDtoList;
    }

    public void setUserCompanyDtoList(List<UserCompanyDto> userCompanyDtoList) {
        this.userCompanyDtoList = userCompanyDtoList;
    }

    public List<UserLinkDto> getUserLinkDtoList() {
        return userLinkDtoList;
    }

    public void setUserLinkDtoList(List<UserLinkDto> userLinkDtoList) {
        this.userLinkDtoList = userLinkDtoList;
    }
}
