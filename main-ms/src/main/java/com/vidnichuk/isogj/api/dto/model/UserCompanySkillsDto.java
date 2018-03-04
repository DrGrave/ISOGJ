package com.vidnichuk.isogj.api.dto.model;

import java.util.List;

public class UserCompanySkillsDto {
    private UserCompanyDto userCompanyDto;
    private List<PositionSkillDto> positionSkillDtoList;

    public UserCompanySkillsDto(UserCompanyDto userCompanyDto, List<PositionSkillDto> positionSkillDtoList) {
        this.userCompanyDto = userCompanyDto;
        this.positionSkillDtoList = positionSkillDtoList;
    }

    public UserCompanySkillsDto() {
    }

    public UserCompanyDto getUserCompanyDto() {
        return userCompanyDto;
    }

    public void setUserCompanyDto(UserCompanyDto userCompanyDto) {
        this.userCompanyDto = userCompanyDto;
    }

    public List<PositionSkillDto> getPositionSkillDtoList() {
        return positionSkillDtoList;
    }

    public void setPositionSkillDtoList(List<PositionSkillDto> positionSkillDtoList) {
        this.positionSkillDtoList = positionSkillDtoList;
    }
}
