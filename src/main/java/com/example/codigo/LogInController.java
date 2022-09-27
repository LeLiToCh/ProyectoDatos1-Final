package com.example.codigo;

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
import java.util.Scanner;


import static com.example.codigo.WriteTXT.userPlaylistsToChoose;


public class LogInController extends DoubleLL<Node> {
    @FXML //instanciamos cada uno de los atributos de nuestro fxml
    private TextField username; // id para nuestro slot de nombre de usuario
    @FXML
    private PasswordField password;// id para nuestro slot de contrasenna
    @FXML
    private Label IncorrectLogIn;// id para nuestro label deacuerdo a ciertos condicionales, ya sea, no ingreso datos, contrsenna o usuarios incorrectos.
    @FXML
    private TextField email; // id para nuestro email de usuario
    @FXML
    private Button button; // id para nuestro boton de acceso
    @FXML
    private ComboBox Provinces; // id para nuestro listado de provincias a elegir
    public String song;
    public String song2;
    public String song3;

    public int user;

    static DoubleLL<Node> songsListt = new DoubleLL<Node>();
    File directory;
    File[] files;

    //Node songP= songsListt.head;
    public static List<File> songplayed= new ArrayList<File>();

    public static DoubleLL<Node> songsToList;
    public static String fvrSongTxt;
    public static String userPlaylist;
    public static String userr;
    public static File userPlaylistpath;


    public void userLogIn(ActionEvent event) throws IOException, InterruptedException, ParserConfigurationException, TransformerException, JDOMException { // metodo que se activa si el boton de acceso es tocado,

        clickLogin();           // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    //public String province = "";

    @FXML // el siguiente metodo tiene que ir como un FXML, porque actua directamente ne el sino, no puede acceder al fxml y cambiar deacuerdo al condicional, si lo quitamos no compila.
    private void clickLogin() throws IOException, InterruptedException, ParserConfigurationException, TransformerException, JDOMException { // metodo que hace las validaciones, entre ellas: contrasenna y usuario correcto o no de los diferentes usuarios, ademas del cambio de escena.

        LogInApplication m = new LogInApplication();

       // XMLController t = new XMLController();
        //ShowXML n = new ShowXML();
        //n.showXML();
        //t.XMLCreator();
        // borrar este condicional antes de enviar, simplemente este es para acceso mas facil y hacer pruebas
        if (username.getText().toString().equals("1") && password.getText().toString().equals("1") && email.getText().toString().equals("1") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("playlistwindow.fxml");
            user= 2;
            fvrSongTxt="C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\favoritesongsEma.txt";
            //userPlaylist= String.valueOf(new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs"));
            System.out.println(userPlaylist);
            userr= "1";
            userPlaylistpath= new File(("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Emmanuel Playlists.txt"));

            //userPlaylist= userPlaylistsToChoose.toString();


        }
        if (username.getText().toString().equals("Emmanuel Esquivel Chavarria") && password.getText().toString().equals("310757") && email.getText().toString().equals("emesquivel@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("playlistwindow.fxml"); // se genera el cambio de escena a la seguna ventana
            user= 2;
            fvrSongTxt="C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\favoritesongsEma.txt";
            userPlaylist= String.valueOf(new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs"));
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
        if(username.getText().isEmpty() && password.getText().isEmpty()){ // si el campo esta vacio generamos un label que lo indique
            IncorrectLogIn.setText("Please type your username & password");
        }
        else { // este condicional se activaria si y solo si algunos de los dos (contrasenna y usuario) o ambos estan malos, generando un label que lo indique.
            IncorrectLogIn.setText("Wrong username or password");
        }
    }
    ArrayList<String> listtoAdd = new ArrayList<>();



}