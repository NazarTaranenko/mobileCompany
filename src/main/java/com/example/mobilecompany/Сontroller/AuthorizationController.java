package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.Object.User;
import com.example.mobilecompany.app.Validation;
import com.example.mobilecompany.Сontroller.Universal.ChangeScene;
import com.example.mobilecompany.Сontroller.Universal.GoToMenuButton;
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
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.mobilecompany.Сontroller.Universal.GoToMenuButton.goToMenuButton;

public class AuthorizationController {
    public  static User user=new User();
    @FXML
    private Button RegisterButton;

    @FXML
    private Button authSiginButton;

    @FXML
    private Text eror2Text;

    @FXML
    private Text erorText;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void Menu(ActionEvent event) throws IOException {
        String loginText = login_field.getText().trim();
        String passwordText = password_field.getText().trim();
        if (Validation.CheckString(loginText) && Validation.CheckNumber(loginText) && Validation.CheckString(passwordText)) {
            loginUser(loginText, passwordText,event);

        } else if (!Validation.CheckString(loginText) && !Validation.CheckString(passwordText)) {
            erorText.setText("Введено некоректне значення");
            eror2Text.setText("Введено некоректне значення");
        } else if (!Validation.CheckNumber(loginText)) {
            erorText.setText("Введено некоректне значення");
            eror2Text.setText("");
        } else if (!Validation.CheckString(passwordText)) {
            erorText.setText("");
            eror2Text.setText("Введено некоректне значення");
        }
    }

    private void loginUser(String loginText, String passwordText, ActionEvent event) throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user1 = new User();
        user1.setPhoneNumber(loginText);
        user1.setPassword(passwordText);
        ResultSet result = dbHandler.getUser(user1);
        int counter = 0;

        try {
            while (result.next()) {
                user.setIdUser(result.getInt(1));
                user.setPhoneNumber(result.getString(2));
                user.setEmeil(result.getString(3));
                user.setPassword(result.getString(4));
                user.setIdTariff(result.getInt(5));
                user.setMoney(result.getInt(6));
                counter++;
            }
        }
        catch(SQLException e){
                throw new RuntimeException(e);
            }

            if (counter >= 1) {
                goToMenuButton(event);
            }


    }
    @FXML
    void Register(ActionEvent event) throws IOException {
        ChangeScene.changeStage(event,"src/main/resources/com/example/mobilecompany/Registration.fxml");
    }

}
