package com.example.codigo;
/**
 * Esta es la clase encargada de la generacion de la primera interfaz grafica,
 * esta genera ciertos atributos que se seguiran utlizando durante el resto del tiempo que este el programa corriendo.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LogInApplication extends Application { //heredamos atributos de java fx
    /**
     * Atributo de stage, se crea este atributo para luego poder editarlo con los diferentes archivos .fxml
     */
    static private Stage stg; //creamos un stg que puede ser cambiado a futuro

    /**
     * Este metodo inicia la interfaz y setea sus caractertisticas mas basicas
     * @param stage stage a generar.
     * @throws Exception excepcion causada durante la carga de los archivos
     */
    @Override
    public void start(Stage stage) throws Exception { // metodo start que genera la primera interfaz y setea sus atributos
        stg = stage;
        stage.setResizable(false); // con esto no puedo hacer fullscreen para que no se alteren las dimensiones
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginwindow.fxml"))); // root padre y su respectivo fxml creado en scene builder
        stage.setTitle("EA Music Player");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }


    /**
     * Este uno de los metodos mas importantes en el codigo, ya que es el que usamos para hacer los cambios de escena.
     * @param fxml fmxl para cambiar.
     * @throws IOException excepcion a la hora de realizar el cambio.
     */
    public void changeScene(String fxml) throws IOException { // el metodo que cambia las pantallas
        Parent pane = FXMLLoader.load(getClass().getResource(fxml)); // aqui luego de un condicional que ocurre en la clase log in controller, se setea el nuevo stage,
        stg.getScene().setRoot(pane);                               // mismo que fue creado para su cambio a posteriori


    }



}