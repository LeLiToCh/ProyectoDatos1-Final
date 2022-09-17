module com.example.codigo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jaco.mp3.player;
    requires org.jetbrains.annotations;


    opens com.example.codigo to javafx.fxml;
    exports com.example.codigo;
}
