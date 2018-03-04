package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.History;

import java.util.List;

public class FullUserInfoDto {
    private MeUserDto meUserDto;
    private UserLinkDto userLinkDto;
    private List<EducationSkillsDto> educationSkillsDtoList;
    private List<UserSkillDto> userSkillDtoList;
    private List<UserCompanySkillsDto> userCompanySkillsDtoList;
    private List<UserLinkDto> userLinkDtoList;
    private List<ExperienceSkillsDto> experienceSkillsDtoList;
    private List<HistorySkillsDto> historySkillsDtoList;
    private List<CoursesSkillsListDto> coursesSkillsListDtoList;

    public FullUserInfoDto(MeUserDto meUserDto, UserLinkDto userLinkDto, List<EducationSkillsDto> educationSkillsDtoList,
                           List<UserSkillDto> userSkillDtoList, List<UserCompanySkillsDto> userCompanySkillsDtoList,
                           List<UserLinkDto> userLinkDtoList, List<ExperienceSkillsDto> experienceSkillsDtoList,
                           List<HistorySkillsDto> historySkillsDtoList,
                           List<CoursesSkillsListDto> coursesSkillsListDtoList) {
        this.meUserDto = meUserDto;
        this.userLinkDto = userLinkDto;
        this.educationSkillsDtoList = educationSkillsDtoList;
        this.userSkillDtoList = userSkillDtoList;
        this.userCompanySkillsDtoList = userCompanySkillsDtoList;
        this.userLinkDtoList = userLinkDtoList;
        this.experienceSkillsDtoList = experienceSkillsDtoList;
        this.historySkillsDtoList = historySkillsDtoList;
        this.coursesSkillsListDtoList = coursesSkillsListDtoList;
    }

    public FullUserInfoDto() {
    }

    public List<EducationSkillsDto> getEducationSkillsDtoList() {
        return educationSkillsDtoList;
    }

    public void setEducationSkillsDtoList(List<EducationSkillsDto> educationSkillsDtoList) {
        this.educationSkillsDtoList = educationSkillsDtoList;
    }

    public List<CoursesSkillsListDto> getCoursesSkillsListDtoList() {
        return coursesSkillsListDtoList;
    }

    public void setCoursesSkillsListDtoList(List<CoursesSkillsListDto> coursesSkillsListDtoList) {
        this.coursesSkillsListDtoList = coursesSkillsListDtoList;
    }

    public List<HistorySkillsDto> getHistorySkillsDtoList() {
        return historySkillsDtoList;
    }

    public void setHistorySkillsDtoList(List<HistorySkillsDto> historySkillsDtoList) {
        this.historySkillsDtoList = historySkillsDtoList;
    }

    public List<ExperienceSkillsDto> getExperienceSkillsDtoList() {
        return experienceSkillsDtoList;
    }

    public void setExperienceSkillsDtoList(List<ExperienceSkillsDto> experienceSkillsDtoList) {
        this.experienceSkillsDtoList = experienceSkillsDtoList;
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



    public List<UserSkillDto> getUserSkillDtoList() {
        return userSkillDtoList;
    }

    public void setUserSkillDtoList(List<UserSkillDto> userSkillDtoList) {
        this.userSkillDtoList = userSkillDtoList;
    }

    public List<UserCompanySkillsDto> getUserCompanySkillsDtoList() {
        return userCompanySkillsDtoList;
    }

    public void setUserCompanySkillsDtoList(List<UserCompanySkillsDto> userCompanySkillsDtoList) {
        this.userCompanySkillsDtoList = userCompanySkillsDtoList;
    }

    public List<UserLinkDto> getUserLinkDtoList() {
        return userLinkDtoList;
    }

    public void setUserLinkDtoList(List<UserLinkDto> userLinkDtoList) {
        this.userLinkDtoList = userLinkDtoList;
    }
}
