module com.example.codecraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.lwjgl;
    requires org.lwjgl.glfw;
    requires org.lwjgl.opengl;

    exports com.example.codecraft.idea;
    opens com.example.codecraft.idea to javafx.fxml;
}