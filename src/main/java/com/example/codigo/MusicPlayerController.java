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



public class MusicPlayerController{
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

    public void previousButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
        if (temp2==false) {
            player.skipBackward();
            songNumber--;
            System.out.println(songNumber);
            System.out.println("holaaaaaa");
        }

        if (temp2==true && songNumber==0){
            player.stop();
            player.removeAll();

            Node current = songsToList.tail;

            System.out.println(songNumber + "sigue cambiando");
            while (current != null) {
                player.addToPlayList((File) current.getData() );
                current = current.getNext();
            }
            player.play();
            songNumber=0;
        }
        if(temp2==true && songNumber!=3){
            player.skipForward();
            songNumber++;
            System.out.println(songNumber + "si cambia");
        }
        player.skipBackward();
        songNumber--;

    }


    public void addToFavoriteBtnGetClicked(ActionEvent event) throws IOException, InterruptedException, JDOMException { // metodo que se activa si el boton de acceso es tocado,


        songToFvrt = String.valueOf(songplayed.get(1)); // aqui poner la variable que tiene el indice que esta reproduciendo, la de temp

        songToFvrt = songToFvrt.replace("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs\\", ""  );
        System.out.println(songToFvrt);
        try
        {
            String filePath = fvrSongTxt;
            FileWriter fw = new FileWriter(filePath, true);
            String lineToAppend = songToFvrt;
            fw.write(lineToAppend);
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



    //DoubleLL canciones= LogInController.usedFiles();
    public void nextButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,

        if (temp2==false) {
            player.stop();

            player = new MP3Player();
            Node current = songsToList.head.getNext();
            songNumber++;
            player.addToPlayList((File) current.getData() );
            player.play();

        }

        if (temp2==true && songNumber>=3){
            System.out.println("sirve");
            player.stop();
            player= new MP3Player();
            Node current= songsToList.head;
            System.out.println(current);
            player.addToPlayList((File) current.getData() );
            player.play();
            songNumber=0;
        }
        if(temp2==true && songNumber!=3){
            player.stop();
            player = new MP3Player();
            Node current = songsToList.head.getNext();
            songNumber++;
            player.addToPlayList((File) current.getData() );
            player.play();
        }
    }
    //Node current = head;
    public void startPlayBtnGetPressed(ActionEvent event) throws IOException, InterruptedException, JDOMException {

        showtheXML();
        player = new MP3Player();

        Node current = songsToList.head;

        player.addToPlayList((File) current.getData() );


        playButton.setVisible(true);
        startPlayButton.setVisible(false);
        pauseButton.setVisible(true);
        //System.out.println(songplayed);

    }
    public void addSongButtonClicked(ActionEvent event) throws IOException, InterruptedException {

        FileChooser songToAdd = new FileChooser();
        String selection = String.valueOf(songToAdd.showOpenDialog(null));
        File filetoadd = new File(selection);
        System.out.println(filetoadd);



        File targetDirectory = new File(userPlaylist);


        if (filetoadd.renameTo(new File(targetDirectory + "\\" + filetoadd.getName()))) {
            System.out.println("File is moved to " + targetDirectory);
        } else {
            System.out.println("Failed");
        }
        //player.addToPlayList(new File(targetDirectory + "\\" + filetoadd.getName()));
        songsToList.addNode(new File(targetDirectory + "\\" + filetoadd.getName()));

    }





    File directory;
    File[] files;



    public void deleteSongButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        player.stop();

        Node current= songsToList.head;
        File fileToDlt= new File(String.valueOf(current.getData()));
        System.out.println(fileToDlt);

        songsToList.remove(current);
        songsToList.displayList();
        player = new MP3Player();
        current = songsToList.head;

        fileToDlt.delete();


        player.addToPlayList((File) current.getData() );
        player.play();

    }




    MP3Player player;
    Boolean Pause = false;
    Boolean temp = true;
    Boolean temp2 = false;
    public void continueRepButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        if (temp2==false) {
            temp2 = true;
        }
        else{
            temp2=false;
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
    public void showtheXML() throws IOException, JDOMException {


        SAXBuilder builder = new SAXBuilder();
        File xml = new File("Adriel Favela X Javier Rosas  La Escuela No Me Gustó Video Oficia.xml");
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
                artistNameLabel.setText(name);
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
        m.changeScene("loginwindow.fxml");
        player.pause();
        playButton.setDisable(false);
    }



}