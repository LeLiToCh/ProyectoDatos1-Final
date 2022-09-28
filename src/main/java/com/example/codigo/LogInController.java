package com.example.codigo;
/**
 * Esta clase es la encargada de controllar la interfaz de LogIn siendo una de las mas importantes,
 * ya que es la primera en ser cargada. Esta clase es la que realiza la verificacion de usuarios.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

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
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * TextField que recopila la info del nombre escrito por el usuario.
     */
    @FXML
    private TextField username;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * PasswordField que recopila la info de la contrasenna escrita por el usuario.
     */
    @FXML
    private PasswordField password;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es elque se muestra
     * en caso de un LogIn incorrecto.
     */
    @FXML
    private Label IncorrectLogIn;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * TextField que recopila la info del correo escrita por el usuario.
     */
    @FXML
    private TextField email;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el del boton para
     * inicio de sesion.
     */
    @FXML
    private Button button;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * ComboBox que recopila la info de la provincia seleccionada por el usuario.
     */
    @FXML
    private ComboBox Provinces;
    /**
     * Atributo tipo string que alamcena a cancion inicial.
     */
    public String song;
    /**
     * Atributo tipo string que alamcena el numero de usuario.
     */
    public int user;
    /**
     * Instanciacion de la clase listadoblemente enlazada circular donde se cargan inicialmente las canciones.
     */
    static DoubleLL<Node> songsListt = new DoubleLL<Node>();
    /**
     * Atributo tipo File para iterar y almacenar en la lista.
     */
    File directory;
    /**
     * Atributo tipo File String para iterar y almacenar en la lista.
     */
    File[] files;
    /**
     * Arraylist con info de cancion reproducida
     */
    public static List<File> songplayed= new ArrayList<File>();
    /**
     * Instanciacicion de clase Lista Doblemente enlazada
     */
    public static DoubleLL<Node> songsToList;
    /**
     * Atributo tipo String para almacenar la direccion del txt de los favoritos.
     */
    public static String fvrSongTxt;
    /**
     * Atributo tipo string con nombre de usuario.
     */
    public static String userr;
    /**
     * Atributo tipo file con direccion de playlists de usuario.
     */
    public static File userPlaylistpath;
    /**
     * Instanciacion de Arduino controller para llamar funcion y crear segundo thread.
     */
    public ArduinoController serialReader = new ArduinoController();
    /**
     * Creacion de reproductor con Jaco Player
     */
    private MP3Player player;
    /**
     * Lista con info de usuarios
     */
    public ArrayList<String> usersdata= new ArrayList<>();

    /**
     * Boton que valida info de usuarios.
     * @param event
     * @throws IOException excepcion cuando realiza comoparaciones.
     * @throws InterruptedException excepcion por interrupcion.
     * @throws ParserConfigurationException excepcion por configuracion.
     * @throws TransformerException excepcion por transformador.
     * @throws JDOMException excepcion por libreria.
     */
    public void userLogIn(ActionEvent event) throws IOException, InterruptedException, ParserConfigurationException, TransformerException, JDOMException {
        clickLogin();
    }

    /**
     * Metodo que es llamado por el boton de log in. Realiza las validaciones de usuario y setea info importante.
     *  @throws IOException excepcion cuando realiza comoparaciones.
     *  @throws InterruptedException excepcion por interrupcion.
     *  @throws ParserConfigurationException excepcion por configuracion.
     *  @throws TransformerException excepcion por transformador.
     *  @throws JDOMException excepcion por libreria.
     */
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
            usersdata.add(username.getText());
            usersdata.add(password.getText());
            usersdata.add(email.getText());
            usersdata.add(Provinces.getSelectionModel().getSelectedItem().toString());
            System.out.println("Users Data:"+  "\n"+usersdata);
        }
        if (username.getText().toString().equals("Emmanuel Esquivel Chavarria") && password.getText().toString().equals("310757") && email.getText().toString().equals("emesquivel@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("playlistwindow.fxml");
            user= 2;
            fvrSongTxt="C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\favoritesongsEma.txt";
            //userPlaylist= String.valueOf(new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs"));
            userr="Emmanuel Esquivel Chavarria";
            userPlaylistpath= new File(("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Emmanuel Playlists.txt"));
            usersdata.add(username.getText());
            usersdata.add(password.getText());
            usersdata.add(email.getText());
            usersdata.add(Provinces.getSelectionModel().getSelectedItem().toString());
            System.out.println("Users Data:"+  "\n"+usersdata);
        }
        if (username.getText().toString().equals("Andres Madrigal Vega") && password.getText().toString().equals("2022") && email.getText().toString().equals("anmadrigalv@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Cartago") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("playlistwindow.fxml");
            user=0;
            fvrSongTxt="C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\favoritesongsAndres.txt";
            //userPlaylist= String.valueOf(new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs1"));
            userr= "Andres Madrigal Vega";
            userPlaylistpath= new File(("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Andres Playlists.txt"));
            usersdata.add(username.getText());
            usersdata.add(password.getText());
            usersdata.add(email.getText());
            usersdata.add(Provinces.getSelectionModel().getSelectedItem().toString());
            System.out.println("Users Data:"+  "\n"+usersdata);
        }
        if(username.getText().isEmpty() && password.getText().isEmpty()){
            IncorrectLogIn.setText("Please type your username & password");
        }
        else {
            IncorrectLogIn.setText("Wrong username or password");
        }
    }

    /**
     * Metodo que setea en player, para evitar problemas con player nulo.
     * @param player player de libreria.
     */
    public void setPlayer(MP3Player player){
        this.player= player;
    }
}