package com.example.codigo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

//import static com.example.codigo.LogInController.userr;


public class PlayListWindowController extends LogInController{

    @FXML
    private Button logOutButton;
    @FXML
    private Button nextButton;
    @FXML
    private Label userName;
    @FXML
    private Button loadPlaylistsBtn;
    @FXML
    private Label labeluserplaylist1;
    @FXML
    private Label labeluserplaylist2;
    @FXML
    private Label labeluserplaylist3;
    @FXML
    private Label labeluserplaylist4;



    public void setnameoftheuser(){
        userName.setText(userr);


    }
    public void labeluserplaylist1GetPressed(MouseEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,

        System.out.println("funcionaaaaaa");

    }
    public void loadPlaylistsBtnGetPressed(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,

        setnameoftheuser();
        labeluserplaylist1.setVisible(true);
        labeluserplaylist1.setDisable(false);
        labeluserplaylist2.setVisible(true);
        labeluserplaylist2.setDisable(false);
        labeluserplaylist3.setVisible(true);
        labeluserplaylist3.setDisable(false);
        labeluserplaylist4.setVisible(true);
        labeluserplaylist4.setDisable(false);
        loadPlaylistsBtn.setVisible(false);




    }

    public void nextButtonGetPressed(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
                                                                          // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    public void logOutButtonGetPressed(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }

}
