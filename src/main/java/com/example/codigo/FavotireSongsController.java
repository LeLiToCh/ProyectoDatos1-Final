package com.example.codigo;

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
    @FXML
    private Label favoriteSongLabel1;
    @FXML
    private Label favoriteSongLabel2;
    @FXML
    private Label favoriteSongLabel3;
    @FXML
    private Label favoriteSongLabel4;
    @FXML
    private Label favoriteSongLabel5;
    @FXML
    private Label favoriteSongLabel6;
    @FXML
    private Label favoriteSongLabel7;
    @FXML
    private Label favoriteSongLabel8;
    @FXML
    private Label favoriteSongLabel9;
    @FXML
    private Label favoriteSongLabel10;
    @FXML
    private Label favoriteSongLabel11;
    @FXML
    private Label favoriteSongLabel12;
    @FXML
    private Button goBackBtnFavorite;
    @FXML
    private Button showfvrtButton;
    InputStream ins ;
    Scanner obj;
    public static List<String> favoriteSongsList= new ArrayList<String>();


    public void showfvrtButtonGetPressed()throws IOException, InterruptedException{

        txtReader();
        goBackBtnFavorite.setVisible(true);
        showfvrtButton.setVisible(false);


    }
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
