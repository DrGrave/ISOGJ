package controllers;

import converters.GenderConverter;
import converters.TypeOfUserConverter;
import entity.Gender;
import entity.TypeOfUser;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import requests.AdminRequests;
import requests.TypeOfUserRequests;

import java.util.Arrays;
import java.util.List;

public class AdminController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField patronymicField;

    @FXML
    private TextField emailField;

    @FXML
    private ChoiceBox<Gender> genderChoice;

    @FXML
    private ChoiceBox<TypeOfUser> typeChoice;

    @FXML
    private TextField cityField;

    private AdminRequests adminRequests = new AdminRequests();
    private TypeOfUserRequests typeOfUserRequests = new TypeOfUserRequests();

    private User iUser;
    private String[] autorization;

    public AdminController(User iUser, String[] autorization) {
        this.iUser = iUser;
        this.autorization = autorization;
    }


    public void initialize(){
        nameField.setText(iUser.getUserName());
        surnameField.setText(iUser.getUserSurname());
        patronymicField.setText(iUser.getUserPatronymic());
        emailField.setText(iUser.getUserEmail());
        cityField.setText(iUser.getCity().getNameOfCity());
        ObservableList<Gender> genders = FXCollections.observableArrayList(Arrays.asList(adminRequests.getAllGenders(autorization)));
        genderChoice.setItems(genders);
        genderChoice.getSelectionModel().select(iUser.getGender().getIdGender()-1);
        GenderConverter genderConverter = new GenderConverter();
        genderChoice.setConverter(genderConverter);
        TypeOfUserConverter typeOfUserConverter = new TypeOfUserConverter();
        ObservableList<TypeOfUser> typeOfUsers = FXCollections.observableArrayList(typeOfUserRequests.getAllTypeOfUsers(autorization));
        typeChoice.setConverter(typeOfUserConverter);
        typeChoice.setItems(typeOfUsers);
        typeChoice.getSelectionModel().select(iUser.getTypeOfUser().getIdTypeOfUser()-1);
    }
}
