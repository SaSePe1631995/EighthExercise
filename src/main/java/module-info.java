module com.example.eighthexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eighthexercise to javafx.fxml;
    exports com.example.eighthexercise;
}