package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.Const;
import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.Object.Tariff;
import com.example.mobilecompany.Сontroller.Universal.GoToMenuButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FindTariffController {


    @FXML
    private TextField internet_field;

    @FXML
    private TextField minute_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField price_field;


DatabaseHandler db = new DatabaseHandler();
    @FXML
    private ListView<Tariff> tariff_plan;

    @FXML
    void findByName(ActionEvent event) {
        tariff_plan.getItems().removeAll();
        tariff_plan.getItems().setAll(db.findlTariff("SELECT * FROM "+ Const.TARIFF_TABLE
                + " WHERE " + Const.TARIFF_NAME + " =?", name_field.getText()));
    }

    @FXML
    void findbyMinute(ActionEvent event) {
        tariff_plan.getItems().removeAll();
        tariff_plan.getItems().setAll(db.findlTariff("SELECT * FROM "+ Const.TARIFF_TABLE
                + " WHERE " + Const.TARIFF_MINUT + " =?", minute_field.getText()));
    }

    @FXML
    void findbyAll(ActionEvent event) {
        tariff_plan.getItems().removeAll();
        tariff_plan.getItems().setAll(db.findlTariffAllPar("SELECT * FROM "+ Const.TARIFF_TABLE
                + " WHERE " + Const.TARIFF_NAME+ " =?"+ " AND "+ Const.TARIFF_INTERNET+ " =?" + " AND "+ Const.TARIFF_MINUT+ " =?"
                + " AND "+ Const.TARIFF_PRICE+ " =?",name_field.getText(), internet_field.getText(), minute_field.getText(),price_field.getText()));
    }

    @FXML
    void findbyInternet(ActionEvent event) {
        tariff_plan.getItems().removeAll();
        tariff_plan.getItems().setAll(db.findlTariff("SELECT * FROM "+ Const.TARIFF_TABLE
                + " WHERE " + Const.TARIFF_INTERNET+ " =?", internet_field.getText()));
    }

    @FXML
    void findbyPrice(ActionEvent event) {
        tariff_plan.getItems().removeAll();
        tariff_plan.getItems().setAll(db.findlTariff("SELECT * FROM "+ Const.TARIFF_TABLE
                + " WHERE " + Const.TARIFF_PRICE + " =?", price_field.getText()));
    }

    @FXML
    void menu(ActionEvent event) throws IOException {
        GoToMenuButton.goToMenuButton(event);
    }

}
