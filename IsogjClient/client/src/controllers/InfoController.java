package controllers;

import entity.User;
import entity.UserSkill;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import requests.SkillRequest;
import javafx.scene.layout.Region;
import  org.controlsfx.control.Rating;


import java.util.Arrays;
import java.util.List;

public class InfoController {

    @FXML
    private TitledPane titledPane;

    @FXML
    private ImageView photoView;

    @FXML
    private ImageView testImage;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField patronymic;

    @FXML
    private TextArea text;

    @FXML
    private Rating userRaiting;

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
                Rating rating = new Rating();
                rating.setOrientation(Orientation.HORIZONTAL);
                rating.setPartialRating(true);
                rating.setRating(Double.parseDouble(userSkill.getSkillMark()));
                rating.setMax(10);
                Tooltip tooltip = new Tooltip("Rating");
                tooltip.setGraphic(rating);
                label.setTooltip(tooltip);
                label.setText(userSkill.getIdSkill().getNameOfSkill());
                System.out.println(userSkill.getIdSkill().getNameOfSkill());
                gridPane.getChildren().add(label);
            }
        }
    }
}
