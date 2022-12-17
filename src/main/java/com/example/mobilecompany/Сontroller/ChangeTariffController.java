package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.Object.Tariff;
import com.example.mobilecompany.Object.User;
import com.example.mobilecompany.Сontroller.Universal.GoToMenuButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.io.IOException;

import static com.example.mobilecompany.Сontroller.AuthorizationController.user;

public class ChangeTariffController {
       DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button buyTariffButton;

    @FXML
    private Text erorText;
    @FXML
    private Button homeButton;

    @FXML
    private TextField tariffBuy;


    @FXML
    private ListView<Tariff> tariff_plan;

    @FXML
    public void initialize() {

        tariff_plan.getItems().setAll(db.checkAllTariff());
    }
    @FXML
    void buyTariff(ActionEvent event) throws IOException {



        Tariff tariff = db.checkTariffByName(tariffBuy.getText());
        if (tariff != null && tariff.getPrice() < user.getMoney()) {
            user.setIdTariff(tariff.getIdTariff());
            user.setMoney(user.getMoney()-tariff.getPrice());
            GoToMenuButton.goToMenuButton(event);
        }else if( tariff.getPrice() < user.getMoney()){
            erorText.setText("Недостатньо коштів на вашому рахунку");
        } else if (tariff != null ) {
            erorText.setText("Тарифу з таким іменем не знайдено");
        }
    }
    @FXML
    void menu(ActionEvent event) throws IOException {
        GoToMenuButton.goToMenuButton(event);
    }

}
