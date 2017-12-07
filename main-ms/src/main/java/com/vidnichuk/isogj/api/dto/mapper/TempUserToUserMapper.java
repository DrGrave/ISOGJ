package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TempUserToUserMapper {

    @Mappings({

    })
    User tempUserToUser(TempUser tempUser);
}
