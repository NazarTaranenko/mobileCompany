package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.Object.Tariff;
import com.example.mobilecompany.Сontroller.Universal.GoToMenuButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class AddTariffController {

    @FXML
    private Button addTariffButton;

    @FXML
    private Text eror2Text;

    @FXML
    private TextField interner_text;

    @FXML
    private TextField minute_text;

    @FXML
    private TextField name_text;

    @FXML
    private TextField price_text;

    @FXML
    void addTariff(ActionEvent event) throws IOException {
        DatabaseHandler db =new DatabaseHandler();
        Tariff tariff= new Tariff(name_text.getText(),interner_text.getText(),minute_text.getText(), Integer.parseInt(price_text.getText()));
        db.addTariff(tariff);
        GoToMenuButton.goToMenuButton(event);
    }

}
