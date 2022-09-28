package com.example.codigo;
/**
 * La clase PlayListWindowController nos permite controllar la interfaz de creacion y seleccion de playlists
 * de los distintos usuarios.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.codigo.WriteTXT.userPlaylistsToChoose;

public class PlayListWindowController extends LogInController{
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton es el
     * encargado de volver a la interfaz de log in de usuarios
     */
    @FXML
    private Button logOutButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton nos permite
     * con la creacion del playlist
     */
    @FXML
    private Button nextButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el label que nos
     * muestra el nombre del usuario en cuestion.
     */
    @FXML
    private Label userName;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton es el que carga
     * todos los labels con las canciones.
     */
    @FXML
    private Button loadPlaylistsBtn;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el Label del playlist 1.
     */
    @FXML
    private Label labeluserplaylist1;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el Label del playlist 2.
     */
    @FXML
    private Label labeluserplaylist2;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el Label del playlist 3.
     */
    @FXML
    private Label labeluserplaylist3;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el Label del playlist 4.
     */
    @FXML
    private Label labeluserplaylist4;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton de creacion de playlist.
     */
    @FXML
    private Button createPlaylistBtn;
    /**
     * Atributo de tipo string que almacena el nombre del playlist seleccionado para su posterior uso.
     */
    public static String chosenplaylist;
    /**
     * Instanciacion de la clase LogInApplication
     */
    LogInApplication m = new LogInApplication();
    /**
     * ArrayList con strings de canciones del playlist del usuario.
     */
    public static List<String> userPlaylistsSongs= new ArrayList<>();
    /**
     * Atributo para uso de almacenamiento de Playlists.
     */
    public static String tmp;
    /**
     * Atributo para uso de almacenamiento de Playlists.
     */
    public static String tmp2;
    /**
     * Atributo para uso de almacenamiento de Playlists.
     */
    public static String tmp3;
    /**
     * Atributo para uso de almacenamiento de Playlists.
     */
    public static String tmp4;
    /**
     * Atributo de tipo string con el nombre de la playlist.
     */
    public static String PlaylistName;
    /**
     * Instanciacion de controlador de arduino.
     */
    private ArduinoController serialReader;

    /**
     * Metodo que setea el nombre del usuario que inicio sesion.
     */
    public void setnameoftheuser(){
        userName.setText(userr);
    }

    /**
     * Metodo que carga el playlist seleccionado por el usuario.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
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

    /**
     * Metodo que carga el playlist seleccionado por el usuario.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
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

    /**
     *  Metodo que carga el playlist seleccionado por el usuario.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void labeluserplaylist3GetPressed(MouseEvent event) throws IOException, InterruptedException {
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

    /**
     * Metodo que carga el playlist seleccionado por el usuario.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void labeluserplaylist4GetPressed(MouseEvent event) throws IOException, InterruptedException {
        try{
            songsToList.songsList.deleteAllNodes();
            chosenplaylist="";
            PlaylistName= "";
        }catch (Exception q){
            System.out.println("La DLL estaba vacia");
        }
        songsListt.songsList = new DoubleLL<Node>();
        directory = new File(userPlaylistsToChoose.get(3));
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

    /**
     *  Metodo que carga todos los nombres de los playlists.
     *  @param event evento que capta cuando el boton es presionado
     *  @throws IOException excepcion causada dependiendo de cierto contexto
     *  @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void loadPlaylistsBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
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

    /**
     * Metodo que carga la interfaz de creacion de una nueva playlist.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void createPlaylistBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
        LogInApplication m = new LogInApplication();
        m.changeScene("createplaylistwindow.fxml");
    }

    /**
     * Metodo para cerrar sesion.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */

    public void logOutButtonGetPressed(ActionEvent event) throws IOException, InterruptedException {
        LogInApplication m = new LogInApplication();
        m.changeScene("loginwindow.fxml");
        userPlaylistsToChoose= new ArrayList<>();
        PlaylistName= "";
    }
}
