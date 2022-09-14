package com.example.codigo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jaco.mp3.player.*;
import javafx.scene.control.Label;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;




public class MusicPlayerController {
    @FXML
    public Label songName;
    @FXML
    private Button playButton;
    @FXML
    private Button pauseButton;
    @FXML
    private Button volumeUpButton;
    @FXML
    private Button volumeDownButton;
    @FXML
    private Button previousButton;
    @FXML
    private Button nextButton;




    public void playButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        playBtnClicked();                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
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
        volumeDownControl(0.2);                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    public void nextButtonClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        volumeDownControl(0.2);                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }


    MP3Player player;


    Boolean Pause = false;
    Boolean temp = true;
    File songFile = new File("Songs\\Adriel Favela X Javier Rosas  La Escuela No Me Gustó Video Oficial.mp3");




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

    private void playBtnClicked(){
        if (temp == true) {

            player = new MP3Player();
            player.addToPlayList(songFile);
            player.play();
            pauseButton.setDisable(false);
            playButton.setDisable(true);
            temp= false;

        }
        else{
            player.play();
            pauseButton.setDisable(false);
            playButton.setDisable(true);



        }
    }

    private void pauseBtnClicked(){
        if (Pause == false){
            player.pause();
            //Pause = true;
            playButton.setDisable(false);
            pauseButton.setDisable(true);
        }
        else{
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