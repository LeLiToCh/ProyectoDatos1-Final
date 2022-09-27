package com.example.codigo;

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
import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static com.example.codigo.LogInController.*;
import static com.example.codigo.PlayListWindowController.*;
import static com.example.codigo.WriteTXT.userPlaylistsToChoose;


public class MusicPlayerController{

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
    private Button volumeUpButton;
    @FXML
    private Button volumeDownButton;
    @FXML
    private Button previousButton;
    @FXML
    private Button nextButton;
    @FXML
    public Button startPlayButton;
    @FXML
    private Button addSongButton;
    @FXML
    private Button deleteSongButton;
    @FXML
    private Button continueRepButton;
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

    public void playButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        playBtnClicked();                                                                      // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    public void pauseButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        pauseBtnClicked();                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    public void volumeUpButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        volumeUpControl(0.2);                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }

    public void volumeDownButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        volumeDownControl(0.2);                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    public void editDataBtnGetClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        LogInApplication m = new LogInApplication();
        m.changeScene("edtiddata.fxml");
        try {
            player.pause();
            playButton.setDisable(false);
        }catch(Exception a){
            System.out.println("");
        }
    }

    public void previousButtonClicked(ActionEvent event) throws IOException, InterruptedException, JDOMException { // metodo que se activa si el boton de acceso es tocado,
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
            showtheXML(tmp); // aqui cambiar a txt
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


    public void addToFavoriteBtnGetClicked(ActionEvent event) throws IOException, InterruptedException, JDOMException { // metodo que se activa si el boton de acceso es tocado,

        songToFvrt = String.valueOf(userPlaylistsSongs.get(songNumber)); // aqui poner la variable que tiene el indice que esta reproduciendo, la de temp

        songToFvrt = songToFvrt.replace(chosenplaylist+"\\", ""  );
        System.out.println(songToFvrt);
        try
        {
            String filePath = fvrSongTxt;
            FileWriter fw = new FileWriter(filePath, true);
            String lineToAppend = songToFvrt;
            fw.write("\n"+lineToAppend);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public void showFavoriteBtnGetPressed(ActionEvent event) throws IOException,InterruptedException{
        LogInApplication m = new LogInApplication();
        m.changeScene("favoriteSongs.fxml");
        player.pause();
        playButton.setDisable(false);

    }



    public static List<String> favoriteSongsList= new ArrayList<String>();


    public void startPlayBtnGetPressed(ActionEvent event) throws IOException, InterruptedException, JDOMException {
        //Write2();
        try {
            player.stop();
        }
        catch(Exception y){
            System.out.println("el reproductor aun no tenia canciones");
            }
        player = new MP3Player();
        tmp = userPlaylistsSongs.get(songNumber);
        tmp = tmp.replace("\\"+PlaylistName, "");
        tmp = tmp.replace(".mp3", ".xml");
        System.out.println("-----------------");
        System.out.println(tmp);
        System.out.println("-----------------");
        showtheXML(tmp); // aqui cambiar a txt

        // current = songsToList.head;
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


        //System.out.println(songplayed);

    }
    public void addSongButtonClicked(ActionEvent event) throws IOException, InterruptedException {
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
        //File song= new File(selection);
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

        playButton.setVisible(true);
        startPlayButton.setVisible(false);
        pauseButton.setVisible(true);
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
        File rn = new File(userPlaylistsSongs.get(songNumber)); // cuando tenga el txt con el playlist nada mas poner el url de la cancion que se este tocando
        System.out.println(rn + "esto es lo q seleccione");
        rn.delete();


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

        playButton.setVisible(true);
        startPlayButton.setVisible(false);
        pauseButton.setVisible(true);
        player.play();
        System.out.println("---------------------------");
        System.out.println(userPlaylistsSongs);
        System.out.println("---------------------------");
        songNumber = 0;

    }


    MP3Player player;
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


    //DoubleLL canciones = LogInController.usedFiles();

    public void playBtnClicked() { // aqui poner un condicional con un booleano para la reproduccion continua

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

        //yearLabel.setText(SongsList.get(1));
        //genreLabel.setText(SongsList.get(2));
        //albumLabel.setText(SongsList.get(3));
        //songNameLabel.setText(SongsList.get(0));

        //artistNameLabel.setText(name);
        // AQUI EDITAR LABELS CON RESPECTO A CANCION SIENDO REPRODUCIDA
        //artistNameLabel.setText(name);

    }

    public void userLogOut(ActionEvent event) throws IOException { // funcion log out hace lo mismo que change scene, solo que aqui cambia la escena a la primera (la del log in)
        LogInApplication m = new LogInApplication();
        m.changeScene("playlistwindow.fxml");
        try {
            player.pause();
            playButton.setDisable(false);
            player = new MP3Player();
        }catch (Exception e){
            System.out.println("Se ha cambiado la escena");
        }

    }






    //public static List<String> userPlaylistsSongs= new ArrayList<>();
    /*
    public static void Write2() {
        userPlaylistsSongs= new ArrayList<>();
        String tmpp=String.valueOf(chosenplaylist);
        String userPlaylistpathtxt= tmpp.replace("\\Songs","\\Songs.txt");
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (String.valueOf(userPlaylistpathtxt));
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null) {
                //System.out.println(linea );
                userPlaylistsSongs.add(linea);
            }
            System.out.println(userPlaylistsSongs + "cuando se corre en el write txt");

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }*/




}