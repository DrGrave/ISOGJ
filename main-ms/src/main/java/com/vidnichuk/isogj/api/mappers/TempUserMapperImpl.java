package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.entity.TempUser;

public class TempUserMapperImpl implements TempUserMapper{

    @Override
    public TempUserDTO fromTempUserToTemUserDTO(TempUser tempUser) {
        TempUserDTO tempUserDTO = new TempUserDTO();
        tempUserDTO.setUserEmail(tempUser.getUserEmail());
        tempUserDTO.setUserLogin(tempUser.getUserLogin());
        tempUserDTO.setUserName(tempUser.getUserName());
        tempUserDTO.setUserPassword(tempUser.getUserPassword());
        tempUserDTO.setUserPatronymic(tempUser.getUserPatronymic());
        tempUserDTO.setUserSurname(tempUser.getUserSurname());
        return tempUserDTO;
    }

    @Override
    public TempUser fromTempUserDTOToTempUser(TempUserDTO tempUserDTO) {
        TempUser tempUser = new TempUser();
        tempUser.setUserEmail(tempUserDTO.getUserEmail());
        tempUser.setUserLogin(tempUserDTO.getUserLogin());
        tempUser.setUserName(tempUserDTO.getUserName());
        tempUser.setUserPassword(tempUserDTO.getUserPassword());
        tempUser.setUserPatronymic(tempUserDTO.getUserPatronymic());
        tempUser.setUserSurname(tempUserDTO.getUserSurname());
        return tempUser;
    }
}
