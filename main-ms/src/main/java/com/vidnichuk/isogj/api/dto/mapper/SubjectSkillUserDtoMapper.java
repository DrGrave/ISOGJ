package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.SubjectSkillUserDto;
import com.vidnichuk.isogj.api.model.SubjectSkillUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectSkillUserDtoMapper {
        SubjectSkillUserDto fromSubjectSkillUserToSubjectSkillUserDto(SubjectSkillUser subjectSkillUser);
}
