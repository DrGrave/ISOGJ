package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.entity.TempUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TempUserMapper {

    TempUserDTO fromTempUserToTemUserDTO(TempUser tempUser);
    @Mappings({
            @Mapping(target = "confirmLink", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    TempUser fromTempUserDTOToTempUser(TempUserDTO tempUserDTO);
}
