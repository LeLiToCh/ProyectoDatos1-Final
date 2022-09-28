package com.example.codigo;
/**
 * Controlador de ventana de edicion de Meta Data, esta clase se comunica directamente con XML Controller para realizar el cambio de informacion.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static com.example.codigo.MusicPlayerController.tmp;

public class EditDataController {
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el boton que nos permite guardar la info escrita.
     */
    @FXML
    public Button saveBtn;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * boton de regreso, para volver a la ventana anterior.
     */
    @FXML
    public Button goBackBtn;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * TextField que recopila la info del nombre escrito por el usuario.
     */
    @FXML
    public TextField newSongNameTextField;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * TextField que recopila la info del nombre de artista escrita por el usuario.
     */
    @FXML
    public TextField newArtistNameTextField;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * TextField que recopila la info del anno escrita por el usuario.
     */
    @FXML
    public TextField newYearTextField;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * TextField que recopila la info del genero escrito por el usuario.
     */
    @FXML
    public TextField newGenreTextField;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo es el de
     * TextField que recopila la info del album escrito por el usuario.
     */
    @FXML
    public TextField newAlbumNameTextField;

    //String name = newSongNameTextField.getText();
    //String artist= newArtistNameTextField.getText();
    //String year = newYearTextField.getText();
    //String genre= newGenreTextField.getText();
    //String album= newAlbumNameTextField.getText();
    /**
     * Instanciacion de XML Controller para edicion de info.
     */
    XMLController r=new XMLController();

    /**
     * Metodo para regresar a ventana anterior
     * @param event click de boton
     * @throws IOException excepcion durante carga.
     * @throws InterruptedException interrupcion durante carga.
     */
    public void goBackBtnGetClicked(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        LogInApplication m = new LogInApplication();
        m.changeScene("2ndWindow.fxml");

    }

    /**
     * Metodo para obtener info de texfield y edicion posterior de XML.
     * @param event click de boton
     * @throws IOException  excepcion durante carga.
     * @throws InterruptedException interrupcion durante carga.
     * @throws ParserConfigurationException interrupcion durante configuracion.
     * @throws TransformerException interrupcion durante transformacion.
     */
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
