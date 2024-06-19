module com.example.programmingtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.programmingtest to javafx.fxml;
    exports com.example.programmingtest;
}