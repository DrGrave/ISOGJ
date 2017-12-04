package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.entity.TempUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TempUserMapper {

    TempUserDTO fromTempUserToTemUserDTO(TempUser tempUser);

    TempUser fromTempUserDTOToTempUser(TempUserDTO tempUserDTO);
}
