package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.entity.TempUser;
import com.vidnichuk.isogj.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TempUserToUserMapper {

    @Mappings({

    })
    User tempUserToUser(TempUser tempUser);
}
