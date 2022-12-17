package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.Object.User;
import com.example.mobilecompany.app.Validation;
import com.example.mobilecompany.Сontroller.Universal.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField Addres_field;

    @FXML
    private Button RegistrationButton;


    @FXML
    private Text erorText;

    @FXML
    private Text erorText2;

    @FXML
    private Text erorText3;

    @FXML
    private TextField number_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void registration(ActionEvent event) throws IOException {
        DatabaseHandler dbhandler = new DatabaseHandler();
        String phoneNumber = number_field.getText();
        String emeil = Addres_field.getText();
        String password = password_field.getText();

        if (Validation.CheckNumber(phoneNumber) && Validation.CheckString(emeil, 100) && Validation.CheckString(password, 100)) {
            User user1 = new User(phoneNumber, emeil, password);
            dbhandler.signUpUser(user1);
            ChangeScene.changeStage(event,"src/main/resources/com/example/mobilecompany/Authorization.fxml");
        }else if (!Validation.CheckNumber(phoneNumber) && !Validation.CheckString(emeil, 100) && !Validation.CheckString(password, 100)){
            erorText.setText("Введені некоректні дані");
            erorText2.setText("Введені некоректні дані");
            erorText3.setText("Введені некоректні дані");
        }else if (!Validation.CheckNumber(phoneNumber) && !Validation.CheckString(emeil, 100) ){
            erorText.setText("Введені некоректні дані");
            erorText2.setText("Введені некоректні дані");
            erorText3.setText("");
        }
        else if (!Validation.CheckNumber(phoneNumber)  ){
            erorText.setText("Введені некоректні дані");
            erorText2.setText("");
            erorText3.setText("");
        }else if ( !Validation.CheckString(emeil, 100) && !Validation.CheckString(password, 100)) {
            erorText.setText("");
            erorText2.setText("Введені некоректні дані");
            erorText3.setText("Введені некоректні дані");
        }else if ( !Validation.CheckString(password, 100)) {
            erorText.setText("");
            erorText2.setText("");
            erorText3.setText("Введені некоректні дані");
        }else if ( !Validation.CheckString(emeil, 100) ) {
            erorText.setText("");
            erorText2.setText("Введені некоректні дані");
            erorText3.setText("");
        }
    }


}
