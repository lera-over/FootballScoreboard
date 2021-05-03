package ru.sag.database.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.sag.database.db.DatabaseHandler;
import ru.sag.database.db.ParentUser;
import ru.sag.database.db.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionnaireController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button jumpToResultButton;

    @FXML
    private CheckBox male_checkbox;

    @FXML
    private CheckBox fulltimeEdu_checkbox;

    @FXML
    private CheckBox hostelYes_checkbox;

    @FXML
    private CheckBox female_checkbox;

    @FXML
    private CheckBox hostelNo_checkbox;

    @FXML
    private CheckBox exttramuralEdu_checkbox;

    @FXML
    private CheckBox surnameFromParentsYes_checkbox;

    @FXML
    private CheckBox surnameFromParentsNo_checkbox;

    @FXML
    private CheckBox guardianYes_checkbox;

    @FXML
    private CheckBox guardianNO_checkbox;

    @FXML
    private CheckBox mother_checkbox;

    @FXML
    private CheckBox father_checkbox;

    @FXML
    private ComboBox<?> speciality_combobox;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField patronymic_field;

    @FXML
    private TextField dob_field;

    @FXML
    private TextField number_field;

    @FXML
    private TextField registration_field;

    @FXML
    private TextField address_field;

    @FXML
    private TextField passportData_field;

    @FXML
    private TextField averageScore_field;

    @FXML
    private TextField surnameParent_field;

    @FXML
    private TextField firstnameParent_field;

    @FXML
    private TextField patronymicParent_field;

    @FXML
    private TextField numberParent_field;

    @FXML
    private TextField registrationParent_field;

    @FXML
    private TextField addressParent_field;

    @FXML
    private TextField jobParent_field;
    private Stage window;

    @FXML
    void initialize() {
        jumpToResultButton.setOnAction(event -> {
            signUpNewEnrolle();
            signUpNewParent();

            jumpToResultButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ru/sag/database/result.fxml"));


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

    private void signUpNewEnrolle() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String surname = surname_field.getText();
        String firstname = firstname_field.getText();
        String patronymic = patronymic_field.getText();
        String dob = dob_field.getText();
        String number = number_field.getText();
        String registration = registration_field.getText();
        String address = address_field.getText();
        String passportData = passportData_field.getText();
        String averageScore = averageScore_field.getText();
        Object speciality = speciality_combobox.getValue();
        String gender = "";
        String hostel = "";
        String education = "";
        String surnameParents = "";
        if(male_checkbox.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";
        if(hostelYes_checkbox.isSelected())
            hostel = "Нужно общежитие";
        else
            hostel = "Не нужно общежитие";
        if(fulltimeEdu_checkbox.isSelected())
            education = "Очная";
        else
            education = "Заочная";
        if(surnameFromParentsYes_checkbox.isSelected())
            surnameParents = "Да";
        else
            surnameParents = "Нет";


        User user = new User(surname, firstname, patronymic, dob, number, registration, address, passportData,
                averageScore, speciality, gender, hostel, education, surnameParents);

        dbHandler.signUpEnrollee(user);
    }

    private void signUpNewParent() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String surnameParent = surnameParent_field.getText();
        String firstnameParent = firstnameParent_field.getText();
        String patronymicParent = patronymicParent_field.getText();
        String numberParent = numberParent_field.getText();
        String registrationParent = registrationParent_field.getText();
        String addressParent = addressParent_field.getText();
        String jobParent = jobParent_field.getText();
        String representative = "";
        String guardianship = "";

        if(guardianYes_checkbox.isSelected())
            guardianship = "Да";
        else
            guardianship = "Нет";
        if(mother_checkbox.isSelected())
            representative = "Мать";
        else
            representative = "Отец";

        ParentUser user = new ParentUser(surnameParent, firstnameParent, patronymicParent, numberParent,
                registrationParent, addressParent, jobParent, representative, guardianship);

        dbHandler.signUpParent(user);
    }
}
