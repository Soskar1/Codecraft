module com.example.codecraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires jaylib;

    exports com.example.codecraft.idea;
    opens com.example.codecraft.idea to javafx.fxml;
}