package com.example.codigo;
import com.fazecast.jSerialComm.*;

import java.util.Scanner;

public class ArduinoController extends Thread{
   MusicPlayerController j = new MusicPlayerController();
    public void arduinocontroller(){


        SerialPort port = SerialPort.getCommPort("COM4");;
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER,0,0);
        Scanner data = new Scanner(port.getInputStream());
        while(data.hasNextLine()){
            System.out.println(data.nextLine());
            j.pauseBtnClicked();
            System.out.println("hola si funciono ayuda");
        }




    }
}
