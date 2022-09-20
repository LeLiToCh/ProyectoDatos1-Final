package com.example.codigo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jaco.mp3.player.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public String songToFvrt;
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
            if(temp2== false) {
                player.skipBackward();
                songNumber--;
            }
            if(temp2==true && songNumber==0){

            }
    }
    public void addToFavoriteBtnGetClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        songToFvrt = String.valueOf(songplayed.get(1));

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
            player.skipForward();
            songNumber++;
            System.out.println(songNumber);
        }

        if (temp2==true && songNumber==3){

                player.pause();

                Node current = songsToList.head;

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
    }



    public void startPlayBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
        player = new MP3Player();
        Node current = songsToList.head;

        while (current != null) {

            player.addToPlayList((File) current.getData() );
            current = current.getNext();

        }
        playButton.setVisible(true);
        startPlayButton.setVisible(false);
        pauseButton.setVisible(true);
        //System.out.println(songplayed);

    }
    public void addSongButtonClicked(ActionEvent event) throws IOException, InterruptedException {



    }
    public void deleteSongButtonClicked(ActionEvent event) throws IOException, InterruptedException {



    }

    public void continueRepClicked(ActionEvent event) throws IOException, InterruptedException {
        if (temp2==false) {
            temp2 = true;
            System.out.println(temp2);
        }
        if (temp2==true){

            temp2=false;
        }
    }


    MP3Player player;
    Boolean Pause = false;
    Boolean temp = true;
    Boolean temp2 = false;
    public boolean continueRepButtonClicked(ActionEvent event) throws IOException, InterruptedException {
        if (temp2==false) {
            temp2 = true;
        }
        else{

            temp2=false;
        }
        return temp2;

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

    public void userLogOut(ActionEvent event) throws IOException { // funcion log out hace lo mismo que change scene, solo que aqui cambia la escena a la primera (la del log in)
        LogInApplication m = new LogInApplication();
        m.changeScene("loginwindow.fxml");
        player.pause();
        playButton.setDisable(false);
    }



}


