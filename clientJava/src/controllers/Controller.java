package controllers;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import requests.LoginController;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button signInButtom;

    @FXML
    private Label incorrectLogPass;

    @FXML
    private GridPane logInForm;

    private LoginController loginController = new LoginController();

    public static String token;

    public static User iUser;


    @FXML
    void signInEvent(ActionEvent event) throws IOException {
        MyUserCredentials user = new MyUserCredentials();
        user.setUserLogin(loginTextField.getText());
        user.setUserPassword(passwordTextField.getText());
        LoginController loginController = new LoginController();
        loginController.loginEvent(user);
    }

    private void openAdminStage() throws IOException {
    }

    private void openStudentStage() throws IOException {

    }

    private void openProfessorStage() throws IOException {
    }

}