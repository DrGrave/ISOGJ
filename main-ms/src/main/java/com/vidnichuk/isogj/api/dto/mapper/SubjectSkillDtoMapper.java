package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.SubjectSkillDto;
import com.vidnichuk.isogj.api.model.SubjectSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectSkillDtoMapper {
    SubjectSkillDto fromSubjectSkillToSubjectSkillDto(SubjectSkill subjectSkill);
}
