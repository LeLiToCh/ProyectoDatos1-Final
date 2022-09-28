package com.example.codigo;
/**
 * La clase XML Controller es la encargada de la edicion de la MetaData,su unica funcion recibe como parametros
 * la nueva informacion que contendra el XML basados en la cancion seleccionada a ser editada.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLController {
    /**
     * Este metodo edita toda la iunfo del XML e inserta los datos que el usuario asi desee.
     * @param TXTPath direccion del XML a editar, en este caso la cancion seleccionada.
     * @param NewName input del usuario, se extrae por medio de un text field.
     * @param NewArtist input del usuario, se extrae por medio de un text field.
     * @param NewYear input del usuario, se extrae por medio de un text field.
     * @param NewGenre input del usuario, se extrae por medio de un text field.
     * @param NewAlbum input del usuario, se extrae por medio de un text field.
     * @throws ParserConfigurationException excepcion de configuracion del XML
     * @throws TransformerException excepcion causada a la hora de transformar la informacion.
     */
    public static void XMLCreator(String TXTPath, String NewName,String NewArtist, String NewYear, String NewGenre,String NewAlbum) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document documento= implementation.createDocument(null,"Songs",null);
        documento.setXmlVersion("1.0");

        Element songss = documento.createElement("Songs");


        Element songs = documento.createElement("Song");

        Element songsName = documento.createElement("Name");
        Text textName=documento.createTextNode(NewName);
        songsName.appendChild(textName);
        songs.appendChild(songsName);

        Element artistName = documento.createElement("Artist");
        Text textartistName=documento.createTextNode(NewArtist);
        artistName.appendChild(textartistName);
        songs.appendChild(artistName);

        Element songsYear = documento.createElement("Year");
        Text textYear=documento.createTextNode(NewYear);
        songsYear.appendChild(textYear);
        songs.appendChild(songsYear);

        Element songsGenre = documento.createElement("Genre");
        Text textGenre=documento.createTextNode(NewGenre);
        songsGenre.appendChild(textGenre);
        songs.appendChild(songsGenre);

        Element songsAlbum = documento.createElement("Album");
        Text textAlbum=documento.createTextNode(NewAlbum);
        songsAlbum.appendChild(textAlbum);
        songs.appendChild(songsAlbum);

        songss.appendChild(songs);

        documento.getDocumentElement().appendChild(songss);


        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File(TXTPath));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source,result);
    }

}


