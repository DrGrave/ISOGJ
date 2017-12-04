package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.entity.TempUser;

public class TempUserMapperImpl implements TempUserMapper{

    @Override
    public TempUserDTO fromTempUserToTemUserDTO(TempUser tempUser) {
        TempUserDTO tempUserDTO = new TempUserDTO();
        tempUserDTO.setUserEmail(tempUser.getEmail());
        tempUserDTO.setUserLogin(tempUser.getUsername());
        tempUserDTO.setUserName(tempUser.getFirstName());
        tempUserDTO.setPassword(tempUser.getPassword());
        tempUserDTO.setUserPatronymic(tempUser.getMiddleName());
        tempUserDTO.setUserSurname(tempUser.getLastName());
        return tempUserDTO;
    }

    @Override
    public TempUser fromTempUserDTOToTempUser(TempUserDTO tempUserDTO) {
        TempUser tempUser = new TempUser();
        tempUser.setEmail(tempUserDTO.getUserEmail());
        tempUser.setUsername(tempUserDTO.getUserLogin());
        tempUser.setFirstName(tempUserDTO.getUserName());
        tempUser.setPassword(tempUserDTO.getPassword());
        tempUser.setMiddleName(tempUserDTO.getUserPatronymic());
        tempUser.setLastName(tempUserDTO.getUserSurname());
        return tempUser;
    }
}
