module com.example.codigo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jaco.mp3.player;


    opens com.example.codigo to javafx.fxml;
    exports com.example.codigo;
}
