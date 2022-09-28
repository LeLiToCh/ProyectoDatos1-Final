package com.example.codigo;
/**
 * Metodo encargado de control de arduino y creacion del thread que se carga de forma paralela, para recibir las sennales del arduino
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import com.fazecast.jSerialComm.*;
import jaco.mp3.player.MP3Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ArduinoController extends Thread{
    /**
     * String de datos que son recibe Java
     */
    String line;
    /**
     * Instanciacion de MusicPlayerController con el fin de llamar sus metodos.
     */
   MusicPlayerController j = new MusicPlayerController();
    /**
     * Creacion de un player de la libreria Jaco Player
     */
   MP3Player player;

    /**
     * Metodo que corre el thread paralelo y recibe las sennales del arduino. Con base a esas sennales realiza diferentes funciones.
     */
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

    /**
     * Funcion que setea el player para evitar hacer un llamado de un player nulo.
     * @param player player de libreria.
     */
    public void setPlayer(MP3Player player){
        this.player= player;
    }

}
