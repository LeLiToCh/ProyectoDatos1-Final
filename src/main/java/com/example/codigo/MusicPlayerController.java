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



public class MusicPlayerController {
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX
     * @code
     */
    @FXML
    public Button logoutbutton;
    @FXML
    public Label songName;
    @FXML
    public ImageView continueRep;
    @FXML
    public Button playButton;
    @FXML
    public Button pauseButton;
    @FXML
    public Button volumeUpButton;
    @FXML
    public Button volumeDownButton;
    @FXML
    public Button previousButton;
    @FXML
    public Button nextButton;
    @FXML
    public Button startPlayButton;
    @FXML
    public Button addSongButton;
    @FXML
    public Button deleteSongButton;
    @FXML
    public Button continueRepButton;
    //boolean temp2= true;
    @FXML
    private Button showFavoriteBtn;
    int songNumber = 0;
    @FXML
    private Button addToFavoriteBtn;
    @FXML
    private Label artistNameLabel;
    @FXML
    private Label songNameLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label albumLabel;
    public String songToFvrt;
    public Node songToRmv;
    @FXML
    public Button warningButton;
    @FXML
    public Label cuntinueRepLabel;
    @FXML
    public Label warningLabel;
    public String userPlaylistssongTXT;
    public Button editDataBtn;
    public static String tmp;
    //public Node canciones = null;
    //LogInController see=new LogInController();
    //FavotireSongsController fvrt= new FavotireSongsController();

    public Boolean status= false;
    /*
    public  void play_pause_arduino(){
        if (status == false){
            playBtnClicked();
            status=true;
        }
        if (status == true){
            pauseBtnClicked();
            status=false;
        }

    }
    */

    /**
     * Llama al metodo play() que hace que el MP3 Player cambie de estado y comience a reproducir musica.
     * @param event evento que capta cuando el boton es presionado
     * @throws IOException excepcion causada dependiendo de cierto contexto
     * @throws InterruptedException si se interrumpe el metodo llamado
     */
    public void playButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        playBtnClicked();
    }

    public void pauseButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        pauseBtnClicked();
    }
    public void volumeUpButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        volumeUpControl(0.2);
    }
    public void volumeDownButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        volumeDownControl(0.2);
    }
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
    int len = userPlaylistsSongs.size()-1;

    /**
     *
     * @param event
     * @throws IOException
     * @throws JDOMException
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

    String lineToAppend;
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
    public void showFavoriteBtnGetPressed(ActionEvent event) throws IOException,InterruptedException{
        LogInApplication m = new LogInApplication();
        m.changeScene("favoriteSongs.fxml");
        player.pause();
        playButton.setDisable(true);
        pauseButton.setDisable(true);
        startPlayButton.setDisable(false);
    }

    public static List<String> favoriteSongsList= new ArrayList<String>();

    Thread hilo = new Thread();
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

    File directory;
    File[] files;
    public File filetocreatee2;

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
    private MP3Player player;
    Boolean Pause = false;
    Boolean temp = true;
    Boolean temp2 = false;
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
    public void continueRepButtonClicked1() throws IOException, InterruptedException {
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

    Boolean songstatus= false;
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

    public static List<String> SongsList= new ArrayList<String>();
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

    public void setPlayer(MP3Player player){
        this.player= player;
    }
}