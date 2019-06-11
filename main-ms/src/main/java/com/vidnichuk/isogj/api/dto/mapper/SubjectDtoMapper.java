package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.SubjectDto;
import com.vidnichuk.isogj.api.model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectDtoMapper {
    SubjectDto fromSubjectToSubjectDto(Subject subject);
}
