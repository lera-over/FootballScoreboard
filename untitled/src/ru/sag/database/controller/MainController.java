package ru.sag.database.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button jumpToQuestButton;

    @FXML
    private ComboBox<?> specialityComboBox;
    private Stage window;

    @FXML
    void initialize() {
        jumpToQuestButton.setOnAction(event -> {


            jumpToQuestButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/ru/sag/database/questionnaire.fxml"));

            try{
                loader.load();
            } catch (IOException e ) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}
