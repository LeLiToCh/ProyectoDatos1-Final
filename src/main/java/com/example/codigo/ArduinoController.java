package com.example.codigo;
import com.fazecast.jSerialComm.*;
import jaco.mp3.player.MP3Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ArduinoController extends Thread{
   String line;
   Integer status;
   Integer statusRC;
   MusicPlayerController j = new MusicPlayerController();
   MP3Player player;
    @Override
    public void run(){
        SerialPort port = SerialPort.getCommPort("COM3");;
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);
        Scanner data = new Scanner(port.getInputStream());

        while(data.hasNextLine()){
           line =data.nextLine();
           String[] info= line.split(";");

            if (Objects.equals(info[0],"0")){
                j.setPlayer(player);
                j.pauseBtnClicked();
                //System.out.println("algo por cualquier vara");
                System.out.println(info[0]);
                System.out.println(info[1]);
                System.out.println(info[2]);
            }


        }

    }
    public void setPlayer(MP3Player player){
        this.player= player;
    }

}
