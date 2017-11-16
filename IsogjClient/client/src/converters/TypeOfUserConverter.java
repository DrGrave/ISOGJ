package converters;

import entity.TypeOfUser;
import javafx.util.StringConverter;
import requests.TypeOfUserRequests;

import java.util.Arrays;
import java.util.List;

import static controllers.Controller.authorization;

public class TypeOfUserConverter extends StringConverter<TypeOfUser>{
    @Override
    public String toString(TypeOfUser object) {
        return object.getNameOfTypeUser();
    }

    @Override
    public TypeOfUser fromString(String string) {
        TypeOfUserRequests typeOfUserRequests = new TypeOfUserRequests();
        List<TypeOfUser> typeOfUsers = Arrays.asList(typeOfUserRequests.getAllTypeOfUsers(authorization));
        return typeOfUsers.get(Integer.parseInt(string));
    }
}
