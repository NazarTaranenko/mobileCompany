module com.example.mobilecompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.mobilecompany.–°ontroller to javafx.fxml;
    exports com.example.mobilecompany;
}