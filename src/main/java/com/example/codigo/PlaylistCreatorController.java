package com.example.codigo;
/**
 * Clase para la creacion de las distintas playlistsv y su carga en el txt de canciones.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.codigo.LogInController.*;

public class PlaylistCreatorController {
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo nos permite
     * mostrar el nombre de la playlist en cuestion.
     */
    @FXML
    private Label PlaylistLabel;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo nos permite
     * obtener el texto ingresado por el usuario.
     */
    @FXML
    private TextField PlaylistNameTextField;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo nos permite
     * llamar la funcion que crea la playlist.
     */
    @FXML
    private Button CreatePlaylistBtn;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este atributo nos permite
     * regresar a la ventana anterior.
     */
    @FXML
    private Button goBackPlaylistCreatorBtn;
    /**
     * Archivo con la direccion de donde crear
     */
    public File filetocreatee;

    /**
     * Metodo llamado por el boton crear, este metodo crea la libreria en la direccion indicada.
     * @param event click en el boton.
     * @throws IOException excepcion durante la carga.
     * @throws InterruptedException interrupcion durante la carga.
     */
    public void CreatePlaylistBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
       String PlaylistName= PlaylistNameTextField.getText();
       File filetowrt= userPlaylistpath;
       FileWriter k = new FileWriter(filetowrt,true);
       k.write("\n"+"C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\"+PlaylistName );
       k.close();
       filetocreatee= new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\"+PlaylistName);
       filetocreatee.mkdirs();

       addtoplaylist();
    }

    /**
     * Metodo para regresar a la ventana anterior
     * @param event click en el boton.
     * @throws IOException excepcion durante la carga.
     * @throws InterruptedException interrupcion durante la carga.
     */
    public void goBackPlaylistCreatorBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
        LogInApplication m = new LogInApplication();
        m.changeScene("playlistwindow.fxml");

    }

    /**
     * Metodo que abre el dialogo de seleccion de cancion para agregar la cancion de nuestra prefernecia al playlist.
     */
    public void addtoplaylist(){
        FileChooser songToAdd = new FileChooser();
        String selection = String.valueOf(songToAdd.showOpenDialog(null));
        File filetoadd = new File(selection);
        System.out.println(filetoadd);


        File targetDirectory = new File(filetocreatee.toURI());


        if (filetoadd.renameTo(new File(targetDirectory + "\\" + filetoadd.getName()))) {
            System.out.println("File is moved to " + targetDirectory);
        } else {
            System.out.println("Failed");
        }

    }

}
