package com.example.codigo;

import jaco.mp3.player.MP3Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.jdom2.JDOMException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LogInController extends DoubleLL<Node> {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label IncorrectLogIn;
    @FXML
    private TextField email;
    @FXML
    private Button button;
    @FXML
    private ComboBox Provinces;
    public String song;
    public int user;
    static DoubleLL<Node> songsListt = new DoubleLL<Node>();
    File directory;
    File[] files;
    public static List<File> songplayed= new ArrayList<File>();
    public static DoubleLL<Node> songsToList;
    public static String fvrSongTxt;
    public static String userPlaylist;
    public static String userr;
    public static File userPlaylistpath;
    public ArduinoController serialReader = new ArduinoController();
    private MP3Player player;
    public void userLogIn(ActionEvent event) throws IOException, InterruptedException, ParserConfigurationException, TransformerException, JDOMException {
        clickLogin();
    }

    @FXML
    private void clickLogin() throws IOException, InterruptedException, ParserConfigurationException, TransformerException, JDOMException {
        LogInApplication m = new LogInApplication();
        //serialReader.setPlayer(player); ESTO EN LA DEFENSA MOSTRARLO
        //serialReader.start();   ESTO EN LA DEFENSA MOSTARLO

        if (username.getText().toString().equals("1") && password.getText().toString().equals("1") && email.getText().toString().equals("1") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("playlistwindow.fxml");
            user= 2;
            fvrSongTxt="C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\favoritesongsEma.txt";
            //System.out.println(userPlaylist);
            userr= "1";
            userPlaylistpath= new File(("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Emmanuel Playlists.txt"));
        }
        if (username.getText().toString().equals("Emmanuel Esquivel Chavarria") && password.getText().toString().equals("310757") && email.getText().toString().equals("emesquivel@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("playlistwindow.fxml");
            user= 2;
            fvrSongTxt="C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\favoritesongsEma.txt";
            //userPlaylist= String.valueOf(new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs"));
            userr="Emmanuel Esquivel Chavarria";
            userPlaylistpath= new File(("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Emmanuel Playlists.txt"));
        }
        if (username.getText().toString().equals("Andres Madrigal Vega") && password.getText().toString().equals("2022") && email.getText().toString().equals("anmadrigalv@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Cartago") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("playlistwindow.fxml");
            user=0;
            fvrSongTxt="C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\favoritesongsAndres.txt";
            //userPlaylist= String.valueOf(new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs1"));
            userr= "Andres Madrigal Vega";
            userPlaylistpath= new File(("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Andres Playlists.txt"));
        }
        if(username.getText().isEmpty() && password.getText().isEmpty()){
            IncorrectLogIn.setText("Please type your username & password");
        }
        else {
            IncorrectLogIn.setText("Wrong username or password");
        }
    }
    public void setPlayer(MP3Player player){
        this.player= player;
    }
}