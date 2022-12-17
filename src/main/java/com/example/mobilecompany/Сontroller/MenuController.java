package com.example.mobilecompany.Сontroller;

import com.example.mobilecompany.Database.DatabaseHandler;
import com.example.mobilecompany.Сontroller.Universal.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.mobilecompany.Сontroller.AuthorizationController.user;
import static com.example.mobilecompany.Сontroller.Universal.ChangeScene.changeStage;

public class MenuController {


    @FXML
    private Text intertText;

    @FXML
    private Text minutText;

    @FXML
    private Text money;

    @FXML
    private Text myTariff;

    @FXML
    private Text phoneNumber;

    @FXML
    private Text priceText;

    @FXML
    private Text countUser;

    @FXML
    public void initialize() {

        DatabaseHandler db = new DatabaseHandler();
        money.setText(String.valueOf(user.getMoney()) + " грн.");
        phoneNumber.setText(user.getPhoneNumber());

         countUser.setText(String.valueOf(db.countUser()));

        ResultSet rs = db.checkTariff(user);

        try {
            while (rs.next()) {
                myTariff.setText("Мій тариф: " + rs.getString(2));
                intertText.setText(rs.getString(3) + " гб.");
                minutText.setText(rs.getString(4) + " хв.");
                priceText.setText(String.valueOf(rs.getInt(5)) + " грн.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addMoney(ActionEvent event) throws IOException {
        changeStage(event,"src/main/resources/com/example/mobilecompany/AddMoney.fxml");
    }

    @FXML
    void addTariff(ActionEvent event) throws IOException {
        changeStage(event,"src/main/resources/com/example/mobilecompany/AddTariff.fxml");
    }

    @FXML
    void changeTarifPlan(ActionEvent event) throws IOException {
        changeStage(event,"src/main/resources/com/example/mobilecompany/ChangeTariff.fxml");
    }

    @FXML
    void findTariff(ActionEvent event) throws IOException {
        changeStage(event,"src/main/resources/com/example/mobilecompany/FindTariff.fxml");
    }

    @FXML
    void sortTariff(ActionEvent event) throws IOException {
        changeStage(event,"src/main/resources/com/example/mobilecompany/SortTariff.fxml");
    }

}
