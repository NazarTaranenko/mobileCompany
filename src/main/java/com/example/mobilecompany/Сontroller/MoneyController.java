package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.app.Validation;
import com.example.mobilecompany.Сontroller.Universal.GoToMenuButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static com.example.mobilecompany.Сontroller.AuthorizationController.user;

public class MoneyController {

    @FXML
    private Button amount;
    @FXML
    private Text erorMessege;
    @FXML
    private TextField setmoney;

    @FXML
    void menu(ActionEvent event) throws IOException {
        DatabaseHandler db = new DatabaseHandler();
        if (Validation.checkParametr(setmoney.getText())) {
            int mon = Integer.parseInt(setmoney.getText());
            db.setMoney(mon, user);
            GoToMenuButton.goToMenuButton(event);
        }else {
            erorMessege.setText("Некоректно введені дані!");
        }
        }
    }


