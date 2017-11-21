package converters;

import entity.Gender;
import javafx.util.StringConverter;
import requests.AdminRequests;

import java.util.Arrays;
import java.util.List;

import static controllers.Controller.authorization;

public class GenderConverter extends StringConverter<Gender>{

    @Override
    public String toString(Gender object) {
        return object.getNameOfGender();
    }

    @Override
    public Gender fromString(String string) {
        AdminRequests adminRequests = new AdminRequests();
        List<Gender> genderList = Arrays.asList(adminRequests.getAllGenders(authorization));
        return genderList.get(Integer.parseInt(string));
    }
}
