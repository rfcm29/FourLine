module com.example.fourline {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fourline to javafx.fxml;
    exports com.example.fourline;
    exports com.example.fourline.server;
    opens com.example.fourline.server to javafx.fxml;
    exports com.example.fourline.client;
    opens com.example.fourline.client to javafx.fxml;
    exports com.example.fourline.utils;
    opens com.example.fourline.utils to javafx.fxml;
}