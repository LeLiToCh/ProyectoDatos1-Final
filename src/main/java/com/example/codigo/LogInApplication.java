package com.example.codigo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LogInApplication extends Application { //heredamos atributos de java fx

    private static Stage stg; //creamos un stg que puede ser cambiado a futuro

    //Prueba eficacia
    @Override
    public void start(Stage stage) throws Exception { // metodo start que genera la primera interfaz y setea sus atributos

        stg = stage;
        stage.setResizable(false); // con esto no puedo hacer fullscreen para que no se alteren las dimensiones
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginwindow.fxml"))); // root padre y su respectivo fxml creado en scene builder
        stage.setTitle("EA Music Player");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }
    public void changeScene(String fxml) throws IOException { // el metodo que cambia las pantallas
        Parent pane = FXMLLoader.load(getClass().getResource(fxml)); // aqui luego de un condicional que ocurre en la clase log in controller, se setea el nuevo stage,
        stg.getScene().setRoot(pane);                               // mismo que fue creado para su cambio a posteriori


    }
}