package com.example.codigo;
/**
 * Controlador de canciones favoritas, esta clase es la encargada de cargar la ventana que
 * carga y muestra las canciones favoritas de los distintos usuarios
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.codigo.LogInController.fvrSongTxt;

public class FavotireSongsController extends MusicPlayerController{
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 1 del usuario
     */
    @FXML
    private Label favoriteSongLabel1;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 2 del usuario
     */
    @FXML
    private Label favoriteSongLabel2;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 3 del usuario
     */
    @FXML
    private Label favoriteSongLabel3;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 4 del usuario
     */
    @FXML
    private Label favoriteSongLabel4;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 5 del usuario
     */
    @FXML
    private Label favoriteSongLabel5;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 6 del usuario
     */
    @FXML
    private Label favoriteSongLabel6;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 7 del usuario
     */
    @FXML
    private Label favoriteSongLabel7;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 8 del usuario
     */
    @FXML
    private Label favoriteSongLabel8;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 9 del usuario
     */
    @FXML
    private Label favoriteSongLabel9;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 10 del usuario
     */
    @FXML
    private Label favoriteSongLabel10;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 11 del usuario
     */
    @FXML
    private Label favoriteSongLabel11;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este label almacena
     * la informacion de la cancion favorita 12 del usuario
     */
    @FXML
    private Label favoriteSongLabel12;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton retorna a la ventana anterior.
     */
    @FXML
    private Button goBackBtnFavorite;
    /**
     * Mediante del @FXML podemos definir interfaces de usuario de manera declarativa,
     * en este caso mediante del uso directo de las API de JavaFX. Este boton muestra los labels
     * con las canciones favoritas.
     */
    @FXML
    private Button showfvrtButton;
    /**
     * Declara los metodos para leer datos.
     */
    InputStream ins ;
    /**
     * Scanner para realizar la lectura
     */
    Scanner obj;
    /**
     * Lista con las canciones favoritas.
     */
    public static List<String> favoriteSongsList= new ArrayList<String>();

    /**
     * Funcion llamada por boton de mostrar las canciones favoritas.
     * @throws IOException excepcion durante carga.
     * @throws InterruptedException interrupcion durante carga.
     */
    public void showfvrtButtonGetPressed()throws IOException, InterruptedException{

        txtReader();
        goBackBtnFavorite.setVisible(true);
        showfvrtButton.setVisible(false);


    }

    /**
     * Lector de TXT con info de favoritos
     * @throws FileNotFoundException direccion de archivo no existente.
     */
    public void txtReader() throws FileNotFoundException {
        favoriteSongsList=new ArrayList<String>();
        ins = new FileInputStream(fvrSongTxt);
        obj = new Scanner(ins);
        while (obj.hasNextLine())
            favoriteSongsList.add(obj.nextLine());
        System.out.println(favoriteSongsList);
        try {
            favoriteSongLabel1.setText(favoriteSongsList.get(0));
            favoriteSongLabel2.setText(favoriteSongsList.get(1));
            favoriteSongLabel3.setText(favoriteSongsList.get(2));
            favoriteSongLabel4.setText(favoriteSongsList.get(3));
            favoriteSongLabel5.setText(favoriteSongsList.get(4));
            favoriteSongLabel6.setText(favoriteSongsList.get(5));
            favoriteSongLabel7.setText(favoriteSongsList.get(6));
            favoriteSongLabel8.setText(favoriteSongsList.get(7));
            favoriteSongLabel9.setText(favoriteSongsList.get(8));
            favoriteSongLabel10.setText(favoriteSongsList.get(9));
            favoriteSongLabel11.setText(favoriteSongsList.get(10));
            favoriteSongLabel12.setText(favoriteSongsList.get(11));
        }catch(Exception e){
            System.out.println("Se cargo correctamente");
        }



    }

    /**
     * Funcion llamada por boton de regreso, retorna a la pantalla anterior.
     * @param event button clicked
     * @throws IOException durante carga.
     * @throws InterruptedException interrupcion durante carga.
     */
    public void goBackBtnFavoriteGetPressed(ActionEvent event) throws IOException, InterruptedException {
        songToFvrt="";
        try {
            favoriteSongLabel1.setText("");
            favoriteSongLabel2.setText("");
            favoriteSongLabel3.setText("");
            favoriteSongLabel4.setText("");
            favoriteSongLabel5.setText("");
            favoriteSongLabel6.setText("");
            favoriteSongLabel7.setText("");
            favoriteSongLabel8.setText("");
            favoriteSongLabel9.setText("");
            favoriteSongLabel10.setText("");
            favoriteSongLabel11.setText("");
            favoriteSongLabel12.setText("");
        } catch (Exception e) {
            System.out.println("Se cargo correctamente");
        }
        LogInApplication m = new LogInApplication();
        m.changeScene("2ndWindow.fxml");



       }
}
