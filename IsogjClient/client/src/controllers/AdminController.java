package controllers;

import converters.GenderConverter;
import converters.TypeOfUserConverter;
import entity.Gender;
import entity.TypeOfUser;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import requests.AdminRequests;
import requests.TypeOfUserRequests;
import requests.UserRequest;

import java.io.IOException;
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
    private AnchorPane anchorPaneInfo;

    @FXML
    private Accordion accordionInfo;

    @FXML
    private TextField cityField;


    private AdminRequests adminRequests = new AdminRequests();
    private TypeOfUserRequests typeOfUserRequests = new TypeOfUserRequests();

    private User iUser;
    private String[] authorization;

    public AdminController(User iUser, String[] authorization) {
        this.iUser = iUser;
        this.authorization = authorization;
    }


    public void initialize() throws IOException {
        nameField.setText(iUser.getUserName());
        surnameField.setText(iUser.getUserSurname());
        patronymicField.setText(iUser.getUserPatronymic());
        emailField.setText(iUser.getUserEmail());
        cityField.setText(iUser.getCity().getNameOfCity());
        ObservableList<Gender> genders = FXCollections.observableArrayList(Arrays.asList(adminRequests.getAllGenders(authorization)));
        genderChoice.setItems(genders);
        genderChoice.getSelectionModel().select(iUser.getGender().getIdGender()-1);
        GenderConverter genderConverter = new GenderConverter();
        genderChoice.setConverter(genderConverter);
        TypeOfUserConverter typeOfUserConverter = new TypeOfUserConverter();
        ObservableList<TypeOfUser> typeOfUsers = FXCollections.observableArrayList(typeOfUserRequests.getAllTypeOfUsers(authorization));
        typeChoice.setConverter(typeOfUserConverter);
        typeChoice.setItems(typeOfUsers);
        typeChoice.getSelectionModel().select(iUser.getTypeOfUser().getIdTypeOfUser()-1);

        initializeInfos();
    }

    private void initializeInfos() throws IOException {
        FXMLLoader load;
        UserRequest userRequest = new UserRequest();
        List<User> userList = Arrays.asList(userRequest.getAllUsers(authorization));
        for (User user : userList) {
            InfoController infoController = new InfoController(iUser, authorization, user);
            load = new FXMLLoader(getClass().getResource("../samples/Info.fxml"));
            load.setController(infoController);
            TitledPane titledPane = load.load();
            titledPane.setText(user.getUserName());
            accordionInfo.getPanes().add(titledPane);
        }
    }
}
