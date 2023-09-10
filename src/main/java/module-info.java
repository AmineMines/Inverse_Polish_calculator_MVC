module com.example.calculatrice_v1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.calculatrice_v1 to javafx.fxml;
    exports com.example.calculatrice_v1;
}