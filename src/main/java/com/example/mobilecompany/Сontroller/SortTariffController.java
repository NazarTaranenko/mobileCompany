package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.Object.Tariff;
import com.example.mobilecompany.Object.TariffPlan;
import com.example.mobilecompany.Сontroller.Universal.GoToMenuButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SortTariffController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button homeButton;



    @FXML
    private ListView<Tariff> tariff_plan;

    @FXML
    public void initialize() {
        DatabaseHandler db = new DatabaseHandler();

        tariff_plan.getItems().setAll(TariffPlan.sortTarifffunc(db.checkAllTariff()));
    }
    @FXML
    void menu(ActionEvent event) throws IOException {
        GoToMenuButton.goToMenuButton(event);
    }

}
