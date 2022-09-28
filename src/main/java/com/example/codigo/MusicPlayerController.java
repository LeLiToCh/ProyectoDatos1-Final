package com.example.codigo;
/**
 * La clase MusicPlayerController es la encargada de la manipulacion y edicion de la interfaz principal de este proyecto
 * en esta clase se estipulan todos los "Buttons", "Labels", entre otros. Mismos que son necesarios para la reproduccion
 * de la musica en el "Music Player". Esta clase tambien es la encargada de cargar otras interfaces como la de "FavoriteSongs",
 * "Edit Data", entre otras.
 *
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 *
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jaco.mp3.player.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import static com.example.codigo.LogInController.*;
import static com.example.codigo.PlayListWindowController.*;
import static com.example.codigo.WriteTXT.userPlaylistsToChoose;


public class MusicPlayerController {
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de boton de
     * log out que permite cerrar sesion si el usuario asi lo desea.
     */
    @FXML
    public Button logoutbutton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo nos permite
     * mostrar el nombre de la cancion obtenido previamente de un XML.
     */
    @FXML
    public Label songName;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Esta es una imagen para reporduccion continua
     */
    @FXML
    public ImageView continueRep;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que
     * nos permiterealizar el llamado a la funcion que reproduce el MP3 Player.
     */
    @FXML
    public Button playButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX.Este es el boton que
     * nos permiterealizar el llamado a la funcion que pausa el MP3 Player.
     */
    @FXML
    public Button pauseButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX.Este boton es el que realiza
     * el llamado a la funcion que nos permite la subida del volumen.
     */
    @FXML
    public Button volumeUpButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton es el que realiza
     * el llamado a la funcion que nos permite bajar el volumen.
     */
    @FXML
    public Button volumeDownButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que
     * llama a la funcion que nos permite acceder a la cancion que antecede a la cancion actual.
     */
    @FXML
    public Button previousButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que
     * llama a la funcion que nos permite acceder a la siguiente cancion.
     */
    @FXML
    public Button nextButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que nos permirte
     * cargar todas las canciones a la lista doblemente enlazada circular.
     */
    @FXML
    public Button startPlayButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton es el que
     * carga el FileChooser para realizar la seleccion de la cancion que queremos agregar.
     */
    @FXML
    public Button addSongButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton es el que nos
     * permite eliminacion de la cancion actual, en caso de ser requerido.
     */
    @FXML
    public Button deleteSongButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton es el que nos
     * permite la activacion de la reproduccion continua, con el fin de poder saltar de la
     * ultima a la primera cancion o viceversa.
     */
    @FXML
    public Button continueRepButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que nos permite
     * mostrar la interfaz de canciones favoritas.
     */
    @FXML
    private Button showFavoriteBtn;
    /**
     * Atributo que indica el indice de la cancion la cual esta siendo reproducida
     */
    int songNumber = 0;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que nos
     * permite agregar la cancion actual a las canciones favoritas.
     */
    @FXML
    private Button addToFavoriteBtn;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Label que nos perimite
     * acceder a la informacion del nombre del artista de la cancion por medio de un XML.
     */
    @FXML
    private Label artistNameLabel;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Label que nos perimite
     * acceder a la informacion del nombre de la cancion por medio de un XML.
     */
    @FXML
    private Label songNameLabel;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Label que nos perimite
     * acceder a la informacion del año de la cancion por medio de un XML.
     */
    @FXML
    private Label yearLabel;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Label que nos perimite
     * acceder a la informacion del genero de la cancion por medio de un XML.
     */
    @FXML
    private Label genreLabel;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Label que nos perimite
     * acceder a la informacion del album al que pertenece la cancion por medio de un XML.
     */
    @FXML
    private Label albumLabel;
    /**
     * Atributo que indica la cancion que esta por ser introducida a favoritos
     */
    public String songToFvrt;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX.
     */
    @FXML
    public Button warningButton;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es un boton que se
     * activa si y solo si se genera un error con la carga de los playlist.
     */
    @FXML
    public Label cuntinueRepLabel;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es un Label que
     * se activa si y solo si la cancion actual es la ultima y el usuario presiona el next,
     * pero aun no esta activado el boton de reproduccion continua.
     */
    @FXML
    public Label warningLabel;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que
     * nos genera la interfaz de edicion de Meta Data.
     */
    @FXML
    public Button editDataBtn;
    /**
     * Atributo de tipo string temporal el cual ayuda a almacenar momentaneamente informacion.
     */
    public static String tmp;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este es el boton que
     * nos permite eliminar la playlist en cuestion.
     */
    @FXML
    public Button deleteThisPlaylistBtn;
    /**
     * Atributo booleano que envia informacion al Arduino controller acerca de la reproduccion.
     */
    public Boolean status= false;

    /**
     * Llama al metodo playBtnClicked() que hace que el MP3 Player cambie de estado y comience a reproducir musica.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void playButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        playBtnClicked();
    }

    /**
     *  Llama al metodo pauseBtnClicked() que hace que el MP3 Player cambie de estado y comience a reproducir musica.
     *  @param event evento que capta cuando el boton es presionado
     *  @throws IOException excepcion causada dependiendo de cierto contexto
     *  @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void pauseButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        pauseBtnClicked();
    }

    /**
     * Llama al metodo volumeUpControl que nos permite poner los valores de
     * volumen que querramos en una escala de 1 a 5.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void volumeUpButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        volumeUpControl(0.2);
    }

    /**
     * Llama al metodo volumeDownControl que nos permite poner los valores de
     * volumen que querramos en una escala de 1 a 5.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void volumeDownButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        volumeDownControl(0.2);
    }

    /**
     * Genera la nueva interfaz para la edicion de la metadata por los valores que se deseen.
     * @param event evento que capta cuando el boton es presionado.
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void editDataBtnGetClicked(ActionEvent event) throws IOException, InterruptedException {
        LogInApplication m = new LogInApplication();
        m.changeScene("edtiddata.fxml");
        try {
            player.pause();
            playButton.setDisable(false);
        }catch(Exception a){
            System.out.println("");
        }
    }

    /**
     * Metodo que nos permite eliminar la playlist que se desee, por medio de la eliminacion
     * de ese directorio en la mini base de datos del usuario.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void deleteThisPlaylistBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
        File tmpp = userPlaylistpath;
        LogInApplication m = new LogInApplication();
        m.changeScene("playlistwindow.fxml");
        try {
            player.stop();
            playButton.setDisable(false);
            player = new MP3Player();
            userPlaylistsSongs= new ArrayList<>();

        }catch (Exception e){
            System.out.println("Se ha cambiado la escena");
        }
        File rn = new File(chosenplaylist);
        System.out.println(rn + "esto es lo q seleccione");
        rn.delete();
        System.out.println(userPlaylistsToChoose);
        userPlaylistsToChoose.remove(new String(chosenplaylist));
        System.out.println(userPlaylistsToChoose);
        File rnn = new File(String.valueOf(userPlaylistpath));
        System.out.println(rnn + "esto es lo q seleccione");
        rnn.delete();
        File filetocreat= new File(String.valueOf(userPlaylistpath));
        userPlaylistpath=tmpp;
        filetocreat.createNewFile();
        File filetowrt= tmpp;
        FileWriter k = new FileWriter(filetowrt,true);
        try {
            for (int i = 0; i <= userPlaylistsToChoose.size(); i++) {
                k.write(userPlaylistsToChoose.get(i));
                k.close();
            }
        }catch(IndexOutOfBoundsException y){
            System.out.println(".");
        }
        userPlaylistsSongs= new ArrayList<>();

    }

    /**
     * Metodo que nos permite acceder a la cancion que antecede a la actual,
     * solo que en caso de estar en la posicion 0, accedera a la ultima si y
     * solo si la reproduccion continua esta activada.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     * @throws JDOMException si se interrumpe la carga del XML
     */
    public void previousButtonClicked(ActionEvent event) throws IOException, InterruptedException, JDOMException {
        if (temp2== false && songNumber==0){
            cuntinueRepLabel.setVisible(true);
            System.out.println(songNumber);
        }
        if (temp2==false && songNumber!=0) {
            cuntinueRepLabel.setVisible(false);
            player.skipBackward();
            songNumber--;
            System.out.println("temp de momento false");
            tmp = userPlaylistsSongs.get(songNumber);
            tmp = tmp.replace("\\"+PlaylistName, "");
            tmp = tmp.replace(".mp3", ".xml");
            System.out.println("-----------------");
            System.out.println(tmp);
            System.out.println("-----------------");
            showtheXML(tmp); // aqui cambiar a txt
            System.out.println(songNumber);
        }
        if (temp2==true && songNumber==0){
            //player.skipBackward();
            System.out.println("temp de momento true");
            tmp = userPlaylistsSongs.get(songNumber);
            tmp = tmp.replace("\\"+PlaylistName, "");
            tmp = tmp.replace(".mp3", ".xml");
            System.out.println("-----------------");
            System.out.println(tmp);
            System.out.println("-----------------");
            showtheXML(tmp); // aqui cambiar a txt
            songNumber= userPlaylistsSongs.size();
            System.out.println(songNumber);
        }
        if(temp2==true && songNumber!=0){
            player.skipBackward();
            songNumber--;
            System.out.println("temp de momento true");
            tmp = userPlaylistsSongs.get(songNumber);
            tmp = tmp.replace("\\"+PlaylistName, "");
            tmp = tmp.replace(".mp3", ".xml");
            System.out.println("-----------------");
            System.out.println(tmp);
            System.out.println("-----------------");
            showtheXML(tmp); // aqui cambiar a txt
            System.out.println(songNumber);
        }
    }

    /**
     * Atributo que nos indica la cantidad de elementos del playlist.
     */
    int len = userPlaylistsSongs.size()-1;

    /**
     *  Metodo que nos permite acceder a la cancion que precede a la actual,
     *  solo que en caso de estar en la ultima poscion, accedera a la primera
     *  si y solo si la reproduccion continua esta activada.
     *  @param event evento que capta cuando el boton es presionado
     *  @throws IOException excepcion causada dependiendo de cierto contexto
     *  @throws JDOMException si se interrumpe la carga del XML
     *
     */
    public void nextButtonClicked(ActionEvent event) throws IOException, JDOMException { // metodo que se activa si el boton de acceso es tocado,
        if (temp2== false && songNumber==len){
            cuntinueRepLabel.setVisible(true);
            System.out.println(songNumber);
        }
        if (temp2==false && songNumber!=len) {
            cuntinueRepLabel.setVisible(false);
            player.skipForward();
            songNumber++;
            System.out.println("temp de momento false");
            tmp = userPlaylistsSongs.get(songNumber);
            tmp = tmp.replace("\\"+PlaylistName, "");
            tmp = tmp.replace(".mp3", ".xml");
            System.out.println("-----------------");
            System.out.println(tmp);
            System.out.println("-----------------");
            showtheXML(tmp);
            System.out.println(songNumber);
        }
        if (temp2==true && songNumber==len){
            //player.skipBackward();
            cuntinueRepLabel.setVisible(false);
            System.out.println("temp de momento true");
            tmp = userPlaylistsSongs.get(songNumber);
            tmp = tmp.replace("\\"+PlaylistName, "");
            tmp = tmp.replace(".mp3", ".xml");
            System.out.println("-----------------");
            System.out.println(tmp);
            System.out.println("-----------------");
            showtheXML(tmp); // aqui cambiar a txt
            songNumber= -1;
            System.out.println(songNumber);
        }
        if(temp2==true && songNumber!=len){
            player.skipForward();
            cuntinueRepLabel.setVisible(false);
            songNumber++;
            System.out.println("temp de momento true");
            tmp = userPlaylistsSongs.get(songNumber);
            tmp = tmp.replace("\\"+PlaylistName, "");
            tmp = tmp.replace(".mp3", ".xml");
            System.out.println("-----------------");
            System.out.println(tmp);
            System.out.println("-----------------");
            showtheXML(tmp); // aqui cambiar a txt
            System.out.println(songNumber);
        }
    }

    /**
     * Atributo tipo string que almacena la info que sera agregada a un txt.
     */
    String lineToAppend;

    /**
     * Metodo que nos permite agregar a favoritos la cancion seleccionada, para mostrarlo posteriormente.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     * @throws JDOMException si se interrumpe la carga del XML
     */
    public void addToFavoriteBtnGetClicked(ActionEvent event) throws IOException, InterruptedException, JDOMException {
        lineToAppend = "";
        songToFvrt = String.valueOf(userPlaylistsSongs.get(songNumber));
        songToFvrt = songToFvrt.replace(chosenplaylist+"\\", ""  );
        System.out.println(songToFvrt);
        try
        {
            String filePath = fvrSongTxt;
            FileWriter fw = new FileWriter(filePath, true);
            lineToAppend = songToFvrt;
            System.out.println(songToFvrt);
            fw.write("\n"+lineToAppend);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(",");
        }
    }

    /**
     *  Metodo que nos permite mostrar las canciones favoritas que han sido seleccionadas por el usuario
     *  @param event evento que capta cuando el boton es presionado
     *  @throws IOException excepcion causada dependiendo de cierto contexto
     *  @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void showFavoriteBtnGetPressed(ActionEvent event) throws IOException,InterruptedException{
        LogInApplication m = new LogInApplication();
        m.changeScene("favoriteSongs.fxml");
        player.pause();
        playButton.setDisable(true);
        pauseButton.setDisable(true);
        startPlayButton.setDisable(false);
    }

    /**
     * ArrayList de tipo string con la lista de canciones favoritas
     */
        public static List<String> favoriteSongsList= new ArrayList<String>();
    /**
     * Metodo que iunstancia la clase hilo, para crear un hilo paralelo al principal y asi poder recibir las sennales desde el arduino
     */
    Thread hilo = new Thread();

    /**
     * Metodo que carga los archivos de tipo file a la lista doblemente enlazada circular, para su posterior carga y reproduccion.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     * @throws JDOMException si se interrumpe la carga del XML
     */
    public void startPlayBtnGetPressed(ActionEvent event) throws IOException, InterruptedException, JDOMException {
        songNumber=0;
        songToFvrt= "";
        try {
            player.stop();
        }
        catch(Exception y){
            System.out.println("el reproductor aun no tenia canciones");
            }
        player = new MP3Player();
        LogInController l = new LogInController();
        l.setPlayer(player);
        tmp = userPlaylistsSongs.get(songNumber);
        tmp = tmp.replace("\\"+PlaylistName, "");
        tmp = tmp.replace(".mp3", ".xml");
        System.out.println("-----------------");
        System.out.println(tmp);
        System.out.println("-----------------");
        showtheXML(tmp);
        try {
            Node current = songsToList.head;
            while (current != null) {
                player.addToPlayList((File) current.getData());
                current = current.getNext();
            }
            playButton.setVisible(true);
            startPlayButton.setVisible(false);
            pauseButton.setVisible(true);
        }catch(Exception i){
            System.out.println("no existe el playlist");
            playButton.setVisible(false);
            startPlayButton.setVisible(false);
            pauseButton.setVisible(false);
            volumeDownButton.setVisible(false);
            volumeUpButton.setVisible(false);
            previousButton.setVisible(false);
            nextButton.setVisible(false);
            logoutbutton.setVisible(false);
            warningButton.setVisible(true);
            warningLabel.setVisible(true);
            addSongButton.setVisible(false);
            addToFavoriteBtn.setVisible(false);
            showFavoriteBtn.setVisible(false);
            continueRepButton.setVisible(false);
        }
        len = userPlaylistsSongs.size()-1;
    }

    /**
     * Metodo que nos permite agregar nuevas canciones al playlist y cargarlas al player.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void addSongButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        //ArduinoController j = new ArduinoController();
        //j.arduinocontroller();
        player.stop();
        pauseButton.setDisable(true);
        playButton.setDisable(false);
        FileChooser songToAdd = new FileChooser();
        String selection = String.valueOf(songToAdd.showOpenDialog(null));
        File filetoadd = new File(selection);
        System.out.println(filetoadd);
        File targetDirectory = new File(chosenplaylist);
        File chosensong= new File(targetDirectory+filetoadd.getName());
        player.addToPlayList(chosensong);
        userPlaylistsSongs.add(String.valueOf(chosensong));
        if (filetoadd.renameTo(new File(targetDirectory + "\\" + filetoadd.getName()))) {
            System.out.println("File is moved to " + targetDirectory);
        } else {
            System.out.println("Failed");
        }
        try{
            songsListt.songsList.deleteAllNodes();

        }catch (Exception q){

            System.out.println("La DLL estaba vacia");
        }
        userPlaylistsSongs= new ArrayList<>();
        songsListt.songsList = new DoubleLL<Node>();
        directory = new File(chosenplaylist); //aqui tendria que ir la direccion de la playlist numero 1 de mi usuario luego hago metodo que lea txt
        files = directory.listFiles();
        if (files != null) {
            for (File archivo : files) {
                songsListt.addNode(archivo);
                songplayed.add(archivo);
                userPlaylistsSongs.add(String.valueOf(archivo));
            }
        }
        player = new MP3Player();
        Node current = songsToList.head;
        while (current != null) {
            player.addToPlayList((File) current.getData());
            current = current.getNext();
        }
        playButton.setVisible(false);
        startPlayButton.setVisible(true);
        pauseButton.setVisible(false);
        System.out.println("------------------------------");
        System.out.println(userPlaylistsSongs);
        System.out.println("------------------------------");
        songNumber = 0;

    }

    /**
     * Directorio (playlist) escogido por el usuario
     */
    File directory;
    /**
     * Lista de tipo file la cual almacena la lista de archivos que proceden del directorio
     */
    File[] files;

    /**
     * Metodo que nos permite eliminar la cancion y volver a cargar la lista doblemente enlazada, solo que SIN ese archivo.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     *
     */
    public void deleteSongButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        System.out.println(userPlaylistsSongs + "aqui busco pa borrar");
        player.stop();
        File rn = new File(userPlaylistsSongs.get(songNumber));
        System.out.println(rn + "esto es lo q seleccione");
        rn.delete();
        pauseButton.setDisable(true);
        playButton.setDisable(false);
        try{
            songsListt.songsList.deleteAllNodes();

        }catch (Exception q){
            System.out.println("La DLL estaba vacia");
        }
        userPlaylistsSongs= new ArrayList<>();
        songsListt.songsList = new DoubleLL<Node>();
        directory = new File(chosenplaylist);
        files = directory.listFiles();
        if (files != null) {
            for (File archivo : files) {
                songsListt.addNode(archivo);
                songplayed.add(archivo);
                userPlaylistsSongs.add(String.valueOf(archivo));
            }
        }
        player = new MP3Player();
        Node current = songsToList.head;
        while (current != null) {
            player.addToPlayList((File) current.getData());
            current = current.getNext();
        }
        playButton.setVisible(false);
        startPlayButton.setVisible(true);
        pauseButton.setVisible(false);
        System.out.println("---------------------------");
        System.out.println(userPlaylistsSongs);
        System.out.println("---------------------------");
        songNumber = 0;
    }

    /**
     * Reproductor MP3 de la clase jaco player.
     */
    private MP3Player player;
    /**
     * Atributo de tippo booleano que indica el estado de reproductor (pausa).
     */
    Boolean Pause = false;
    /**
     * Atributo de tipo booleano que nos indica el estado del reproductor (play).
     */
    Boolean temp = true;
    /**
     * Atributo de tipo booleano que indica el estado de la reproduccion continua.
     */
    Boolean temp2 = false;

    /**
     * Metodo que setea el estado de temp2 mismo atributo que hace que la reproduccion contunua sea verdadero o falso.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void continueRepButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        if (temp2==false) {
            temp2 = true;
            System.out.println(temp2);
            player.setRepeat(true);
        }
        else{
            player.setRepeat(false);
            temp2=false;
            System.out.println(temp2);
        }
    }
    /**
     * Metodo que setea el volumen dependiendo de los valores de entrada.
     */
    private void volumeDownControl(Double value) {

        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers) {
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for (Line.Info lineInfo : lineInfos) {
                Line line = null;
                boolean opened = true;
                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if (!opened) {
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = value;
                    float changeCalc = (float) ((float) currentVolume - (double) volumeToCut);
                    volControl.setValue((changeCalc));
                } catch (LineUnavailableException lineException) {
                } catch (IllegalArgumentException illException) {
                } finally {
                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }

        }

    }
    /**
     * Metodo que setea el volumen dependiendo de los valores de entrada.
     */
    private void volumeUpControl(Double value) {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers) {
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for (Line.Info lineInfo : lineInfos) {
                Line line = null;
                boolean opened = true;
                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if (!opened) {
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = value;
                    float changeCalc = (float) ((float) currentVolume + (double) volumeToCut);
                    volControl.setValue((changeCalc));
                } catch (LineUnavailableException lineException) {
                } catch (IllegalArgumentException illException) {
                } finally {
                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }

        }

    }

    /**
     * Metodo que activa la reproducion del MP3 Player.
     */
    public  void playBtnClicked() {
        nextButton.setDisable(false);
        previousButton.setDisable(false);
        if (temp == true) {

            player.play();
            pauseButton.setDisable(false);
            playButton.setDisable(true);
            temp = false;
        } else {
            player.play();
            pauseButton.setDisable(false);
            playButton.setDisable(true);
        }
        System.out.println(player.getUI());
    }

    /**
     * Metodo que desactiva la reproducion del MP3 Player.
     */
    public void pauseBtnClicked() {
        try {
            if (Pause == false) {
                player.pause();
                //Pause = true;
                playButton.setDisable(false);
                pauseButton.setDisable(true);
                nextButton.setDisable(true);
                previousButton.setDisable(true);
            } else {
                player.play();
                Pause = false;
            }
        }catch (NullPointerException k){
            System.out.println(".");
        }
    }

    /**
     * Atributo de tipo ArrayList que almacena la lista de canciones.
     */
    public static List<String> SongsList= new ArrayList<String>();

    /**
     * Metodo que muestra el XML en pantalla.
     * @param songNamee evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws JDOMException si se interrumpe la carga del XML
     */
    public void showtheXML(String songNamee) throws IOException, JDOMException {


        SAXBuilder builder = new SAXBuilder();
        File xml = new File(songNamee);
        Document document = builder.build(xml);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren("Songs");


        for (int i = 0; i < list.size(); i++) {
            Element song = list.get(i);

            List<Element> valores_song = song.getChildren();
            for (int j = 0; j < valores_song.size(); j++) {
                Element cmapo = valores_song.get(j);
                String name = cmapo.getChildTextTrim("Name");
                String year = cmapo.getChildTextTrim("Year");
                String genre = cmapo.getChildTextTrim("Genre");
                String album = cmapo.getChildTextTrim("Album");
                String artist = cmapo.getChildTextTrim("Artist");
                System.out.println(name + "\t" + year + "\t" + genre + "\t" + album + "\t" + artist);
                artistNameLabel.setText(artist);
                yearLabel.setText(year);
                genreLabel.setText(genre);
                albumLabel.setText(album);
                songNameLabel.setText(name);

            }
        }
    }

    /**
     * Metodo para volver a la ventana de playlist del usuario
     * @param event
     * @throws IOException excepcion causada dependiendo de cierto contexto
     *
     */

    public void userLogOut(ActionEvent event) throws IOException { // funcion log out hace lo mismo que change scene, solo que aqui cambia la escena a la primera (la del log in)
        LogInApplication m = new LogInApplication();
        m.changeScene("playlistwindow.fxml");
        try {
            player.pause();
            playButton.setDisable(false);
            player = new MP3Player();
            userPlaylistsSongs= new ArrayList<>();

        }catch (Exception e){
            System.out.println("Se ha cambiado la escena");
        }
        //stop();

    }

    /**
     * Metodo para setar el player, con esto puede ser llamado en cualquier momento.
     * @param player
     */
    public void setPlayer(MP3Player player){
        this.player= player;
    }
}