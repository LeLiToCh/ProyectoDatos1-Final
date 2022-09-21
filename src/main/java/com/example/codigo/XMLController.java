package com.example.codigo;

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
    public void XMLCreator() throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document documento= implementation.createDocument(null,"Songs",null);
        documento.setXmlVersion("1.0");

        Element songss = documento.createElement("Songs");


        Element songs = documento.createElement("Song");

        Element songsName = documento.createElement("Name");
        Text textName=documento.createTextNode("MOJA TOTO");
        songsName.appendChild(textName);
        songs.appendChild(songsName);

        Element artistName = documento.createElement("Artist");
        Text textartistName=documento.createTextNode("Dowba Montana x El Cherry Scom");
        artistName.appendChild(textartistName);
        songs.appendChild(artistName);

        Element songsYear = documento.createElement("Year");
        Text textYear=documento.createTextNode("2022");
        songsYear.appendChild(textYear);
        songs.appendChild(songsYear);

        Element songsGenre = documento.createElement("Genre");
        Text textGenre=documento.createTextNode("Dembow");
        songsGenre.appendChild(textGenre);
        songs.appendChild(songsGenre);

        Element songsAlbum = documento.createElement("Album");
        Text textAlbum=documento.createTextNode("Sencillo");
        songsAlbum.appendChild(textAlbum);
        songs.appendChild(songsAlbum);

        songss.appendChild(songs);

        documento.getDocumentElement().appendChild(songss);


        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File("MOJA TOTO.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source,result);
    }

}


