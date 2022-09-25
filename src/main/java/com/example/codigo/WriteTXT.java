package com.example.codigo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.codigo.LogInController.userPlaylistpath;

public class WriteTXT {
    public static List<String> userPlaylistsToChoose= new ArrayList<>();
    public static void Write() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (String.valueOf(userPlaylistpath));
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null) {
                //System.out.println(linea );
                userPlaylistsToChoose.add(linea);
            }
            System.out.println(userPlaylistsToChoose + "cuando se corre en el write txt");

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
