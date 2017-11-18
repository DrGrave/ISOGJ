package controllers;

import entity.User;
import entity.UserSkill;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import requests.SkillRequest;

import java.util.Arrays;
import java.util.List;

public class InfoController {

    @FXML
    private TitledPane titledPane;

    @FXML
    private Canvas picture;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField patronymic;

    private User iUser;
    private String[] authorization;
    private User user;

    public InfoController(User iUser, String[] authorization, User user) {
        this.iUser = iUser;
        this.authorization = authorization;
        this.user = user;
    }

    public void initialize(){
        name.setText(user.getUserName());
        surname.setText(user.getUserSurname());
        patronymic.setText(user.getUserPatronymic());
        SkillRequest skillRequest = new SkillRequest();
        if (skillRequest.getAllUserSkills(authorization,user.getUserId()) != null){
        List<UserSkill> userSkills = Arrays.asList(skillRequest.getAllUserSkills(authorization, user.getUserId()));
            for (UserSkill userSkill: userSkills) {
                Label label = new Label();
                label.setText(userSkill.getIdSkill().getNameOfSkill());
                System.out.println(userSkill.getIdSkill().getNameOfSkill());
                gridPane.getChildren().add(label);
            }
        }
    }
}
