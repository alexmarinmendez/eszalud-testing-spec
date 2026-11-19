module com.example.eszaludtesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eszaludtesting to javafx.fxml;
    exports com.example.eszaludtesting;
}