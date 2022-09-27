package com.example.codigo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import static com.example.codigo.LogInController.userr;
import static com.example.codigo.LogInController.*;
import static com.example.codigo.WriteTXT.userPlaylistsToChoose;

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
    @FXML
    private Button createPlaylistBtn;
    public static String chosenplaylist;
    LogInApplication m = new LogInApplication();
    public static List<String> userPlaylistsSongs= new ArrayList<>();

    public static String tmp;
    public static String tmp2;
    public static String tmp3;

    public static String tmp4;
    public static String PlaylistName;

    public void setnameoftheuser(){
        userName.setText(userr);


    }
    public void labeluserplaylist1GetPressed(MouseEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,

        try{
            PlaylistName= "";
            songsListt.songsList.deleteAllNodes();
            chosenplaylist="";


        }catch (Exception q){

            System.out.println("La DLL estaba vacia");
        }
        songsListt.songsList = new DoubleLL<Node>();
        System.out.println(userPlaylistsToChoose.get(0) + "esta es la referencia");
        directory = new File(userPlaylistsToChoose.get(0)); //aqui tendria que ir la direccion de la playlist numero 1 de mi usuario luego hago metodo que lea txt
        files = directory.listFiles();
            if (files != null) {
                for (File archivo : files) {
                    songsListt.addNode(archivo);
                    songplayed.add(archivo);
                    userPlaylistsSongs.add(String.valueOf(archivo));
                }
            }
            songsToList = songsListt;
            songsListt.displayList();
            System.out.println(songplayed);

            if (userPlaylistsToChoose.get(0) == null){
                System.out.println("No existe playlist creada!");

            }
            else {
                m.changeScene("2ndWindow.fxml");

            }
            chosenplaylist= userPlaylistsToChoose.get(0);
        System.out.println("--------------------------------------------");
        System.out.println(userPlaylistsSongs);
        System.out.println("--------------------------------------------");
        PlaylistName=tmp;
    }
    public void labeluserplaylist2GetPressed(MouseEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        try{
            PlaylistName= "";
            songsToList.songsList.deleteAllNodes();
            chosenplaylist="";

        }catch (Exception q){
            System.out.println("La DLL estaba vacia");
        }
        songsListt.songsList = new DoubleLL<Node>();
        System.out.println(userPlaylistsToChoose.get(1) + "esta es la referencia");
        directory = new File(userPlaylistsToChoose.get(1)); //aqui tendria que ir la direccion de la playlist numero 1 de mi usuario luego hago metodo que lea txt
        files = directory.listFiles();
        if (files != null) {
            for (File archivo : files) {
                songsListt.addNode(archivo);
                songplayed.add(archivo);
                userPlaylistsSongs.add(String.valueOf(archivo));
            }
        }
        songsToList = songsListt;
        songsListt.displayList();
        System.out.println(songplayed);

        if (userPlaylistsToChoose.get(1)==null){
            System.out.println("No existe playlist creada!");

        }
        else {
            m.changeScene("2ndWindow.fxml");

        }
        chosenplaylist= userPlaylistsToChoose.get(1);
        PlaylistName=tmp2;
    }
    public void labeluserplaylist3GetPressed(MouseEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        try{
            songsToList.songsList.deleteAllNodes();
            chosenplaylist="";
            PlaylistName= "";

        }catch (Exception q){
            System.out.println("La DLL estaba vacia");
        }
        songsListt.songsList = new DoubleLL<Node>();
        try {
            directory = new File(userPlaylistsToChoose.get(2));
            files = directory.listFiles();
            if (files != null) {
                for (File archivo : files) {
                    songsListt.addNode(archivo);
                    songplayed.add(archivo);
                    userPlaylistsSongs.add(String.valueOf(archivo));
                }
            }
            songsToList = songsListt;
            songsListt.displayList();
            System.out.println(songplayed);
        }catch (Exception k){
            labeluserplaylist3.setText("This Playlist Does Not Exist!");
        }


        if (userPlaylistsToChoose.get(2) == null){
            System.out.println("No existe playlist creada!");

        }
        else {
            m.changeScene("2ndWindow.fxml");

        }
        chosenplaylist= userPlaylistsToChoose.get(2);
        PlaylistName=tmp3;
    }
    public void labeluserplaylist4GetPressed(MouseEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        try{
            songsToList.songsList.deleteAllNodes();
            chosenplaylist="";
            PlaylistName= "";

        }catch (Exception q){
            System.out.println("La DLL estaba vacia");
        }
        songsListt.songsList = new DoubleLL<Node>();
        directory = new File(userPlaylistsToChoose.get(3)); //aqui tendria que ir la direccion de la playlist numero 1 de mi usuario luego hago metodo que lea txt
        files = directory.listFiles();
        if (files != null) {
            for (File archivo : files) {
                songsListt.addNode(archivo);
                songplayed.add(archivo);
                userPlaylistsSongs.add(String.valueOf(archivo));
            }
        }
        songsToList = songsListt;
        songsListt.displayList();
        System.out.println(songplayed);


        if (userPlaylistsToChoose.get(3) == null){
            System.out.println("No existe playlist creada!");
        }
        else {
            m.changeScene("2ndWindow.fxml");
        }
        chosenplaylist= userPlaylistsToChoose.get(3);
        PlaylistName=tmp4;
    }

    public void loadPlaylistsBtnGetPressed(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        userPlaylistsToChoose= new ArrayList<>();
        WriteTXT.Write();
        setnameoftheuser();
        try {
            tmp = userPlaylistsToChoose.get(0);
            tmp = tmp.replace("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\", "");
            labeluserplaylist1.setText(tmp);
            tmp2 = userPlaylistsToChoose.get(1);
            tmp2 = tmp2.replace("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\", "");
            labeluserplaylist2.setText(tmp2);
            tmp3 = userPlaylistsToChoose.get(2);
            tmp3 = tmp3.replace("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\", "");
            labeluserplaylist3.setText(tmp3);
            tmp4 = userPlaylistsToChoose.get(3);
            tmp4 = tmp4.replace("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\", "");
            labeluserplaylist4.setText(tmp4);
        }catch (Exception l){
            System.out.println("Nombres estipulados");
        }
        labeluserplaylist1.setVisible(true);
        labeluserplaylist1.setDisable(false);
        labeluserplaylist2.setVisible(true);
        labeluserplaylist2.setDisable(false);
        labeluserplaylist3.setVisible(true);
        labeluserplaylist3.setDisable(false);
        labeluserplaylist4.setVisible(true);
        labeluserplaylist4.setDisable(false);
        loadPlaylistsBtn.setVisible(false);
        createPlaylistBtn.setVisible(true);
    }

    public void createPlaylistBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
        LogInApplication m = new LogInApplication();
        m.changeScene("createplaylistwindow.fxml"); // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }

    public void logOutButtonGetPressed(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        LogInApplication m = new LogInApplication();
        m.changeScene("loginwindow.fxml"); // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
        userPlaylistsToChoose= new ArrayList<>();
        PlaylistName= "";

    }

}
