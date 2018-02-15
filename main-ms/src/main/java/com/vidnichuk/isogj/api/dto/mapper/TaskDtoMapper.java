package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.TaskDto;
import com.vidnichuk.isogj.api.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {
    TaskDto fromTaskToTaskDto(Task task);
}
