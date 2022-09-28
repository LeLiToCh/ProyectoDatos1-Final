package com.example.codigo;
/**
 * La clase Write TXT es la encargada de cargar todos los playlists del usuario a una lista simple, para su posterior uso.
 * Su unico metodo se encarga de leer un txt y gardar todo lo leido.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.codigo.LogInController.userPlaylistpath;

public class WriteTXT {
    /**
     * ArrayList con strings que almacena todas las direcciones de los playlists a elegir por los usuarios.
     */
    public static List<String> userPlaylistsToChoose= new ArrayList<>();

    /**
     * Metodo de lectura y escritura de txt.
     */
    public static void Write() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File (String.valueOf(userPlaylistpath));
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

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
