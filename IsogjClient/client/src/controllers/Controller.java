package controllers;



import entity.MyUserCredentials;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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

    public static String[] authorization;

    public static User iUser;


    @FXML
    void signInEvent(ActionEvent event) throws IOException {
        MyUserCredentials userCredentials = new MyUserCredentials();
        userCredentials.setUserLogin(loginTextField.getText());
        userCredentials.setUserPassword(passwordTextField.getText());
        LoginController loginController = new LoginController();
        authorization = loginController.loginEvent(userCredentials);
        if (authorization != null){
            iUser = loginController.getUser(authorization);
            if (iUser.getTypeOfUser().getIdTypeOfUser() == 1){
                System.out.println(iUser.getUserEmail());
            }else if (iUser.getTypeOfUser().getIdTypeOfUser() == 2){

            }else if (iUser.getTypeOfUser().getIdTypeOfUser() == 3){
                openAdminStage(iUser, authorization);
                System.out.println(iUser.getUserEmail());
                signInButtom.getScene().getWindow().hide();
            }
        }
    }

    private void openAdminStage(User iUser, String[] autorization) throws IOException {
        Stage stage = new Stage();
        AdminController adminController = new AdminController(iUser, autorization);
        FXMLLoader load = new  FXMLLoader(getClass().getResource("../samples/Admin.fxml"));
        load.setController(adminController);
        Scene scene = new Scene((Parent) load.load());
        stage.setScene(scene);
        stage.setTitle("Admin client");
        stage.show();
    }

    private void openStudentStage() throws IOException {

    }

    private void openProfessorStage() throws IOException {
    }

}