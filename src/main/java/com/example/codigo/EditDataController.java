package com.example.codigo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static com.example.codigo.MusicPlayerController.tmp;

public class EditDataController {
    @FXML
    public Button saveBtn;
    @FXML
    public Button goBackBtn;
    @FXML
    public TextField newSongNameTextField;
    @FXML
    public TextField newArtistNameTextField;
    @FXML
    public TextField newYearTextField;
    @FXML
    public TextField newGenreTextField;
    @FXML
    public TextField newAlbumNameTextField;

    //String name = newSongNameTextField.getText();
    //String artist= newArtistNameTextField.getText();
    //String year = newYearTextField.getText();
    //String genre= newGenreTextField.getText();
    //String album= newAlbumNameTextField.getText();
    XMLController r=new XMLController();
    public void goBackBtnGetClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        LogInApplication m = new LogInApplication();
        m.changeScene("2ndWindow.fxml");

    }
    public void saveBtnGetClicked(ActionEvent event) throws IOException, InterruptedException, ParserConfigurationException, TransformerException { // metodo que se activa si el boton de acceso es tocado,
        String name = newSongNameTextField.getText();
        String artist= newArtistNameTextField.getText();
        String year = newYearTextField.getText();
        String genre= newGenreTextField.getText();
        String album= newAlbumNameTextField.getText();
        r.XMLCreator(tmp,name,artist,year,genre,album);

        LogInApplication m = new LogInApplication();
        m.changeScene("2ndWindow.fxml");


    }

}
