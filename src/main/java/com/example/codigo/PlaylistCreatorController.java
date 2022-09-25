package com.example.codigo;

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

    @FXML
    private Label PlaylistLabel;
    @FXML
    private TextField PlaylistNameTextField;
    @FXML
    private Button CreatePlaylistBtn;
    @FXML
    private Button goBackPlaylistCreatorBtn;

    public File filetocreatee;

    public void CreatePlaylistBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
       String PlaylistName= PlaylistNameTextField.getText();
       File filetowrt= userPlaylistpath;
       FileWriter k = new FileWriter(filetowrt,true);
       k.write("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\"+PlaylistName);
       k.close();
       filetocreatee= new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\"+PlaylistName);
       filetocreatee.mkdirs();

       addtoplaylist();
    }
    public void goBackPlaylistCreatorBtnGetPressed(ActionEvent event) throws IOException, InterruptedException {
        LogInApplication m = new LogInApplication();
        m.changeScene("playlistwindow.fxml");

    }

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
        //player.addToPlayList(new File(targetDirectory + "\\" + filetoadd.getName()));
        //songsToList.addNode(new File(targetDirectory + "\\" + filetoadd.getName()));




    }




}
