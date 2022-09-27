package com.example.codigo;
import com.fazecast.jSerialComm.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ArduinoController extends Thread{
   String line;
   Integer status;
   Integer statusRC;
   MusicPlayerController j = new MusicPlayerController();
    @Override
    public void run(){
        SerialPort port = SerialPort.getCommPort("COM4");;
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);
        Scanner data = new Scanner(port.getInputStream());

        while(data.hasNextLine()){
           line =data.nextLine();
          String[] info= line.split(";");
           status= Integer.valueOf(info[0]);
           statusRC= Integer.valueOf(info[1]);

           /*
           if (Objects.equals(info[0],"1")){
               j.pauseBtnClicked();
               if (j.songstatus == false) {
                   j.player.pause();
                   //Pause = true;
                   j.playButton.setDisable(false);
                   j.pauseButton.setDisable(true);
                   j.nextButton.setDisable(true);
                   j.previousButton.setDisable(true);

           }
           if (Objects.equals(info[0],"0")){
                j.pauseBtnClicked();

           }
           */
            if (Objects.equals(info[1],"1")){
                j.temp2 = true;

            }
            if (Objects.equals(info[1],"0")){
                j.temp2 = false;

            }


        }
        System.out.println(status);
        System.out.println(statusRC);




    }

}
