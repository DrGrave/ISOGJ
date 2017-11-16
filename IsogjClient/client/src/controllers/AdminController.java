package controllers;

import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import requests.AdminRequests;

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
    private ChoiceBox<?> genderChoice;

    @FXML
    private ChoiceBox<?> typeChoice;

    @FXML
    private TextField cityField;

    AdminRequests adminRequests = new AdminRequests();

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

    }
}
