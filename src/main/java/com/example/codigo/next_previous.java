package com.example.codigo;

import java.util.Arrays;

public class next_previous {
    private String[] song;
    private int[] favoriteSongs;
    private int songPlaying;

    public static void IDSong(String[] args) {
        String[] song = {
                "Songs\\Adriel Favela X Javier Rosas  La Escuela No Me Gustó Video Oficial.mp3",
                "Songs\\Amenazzy ft Rochy RD  Miedo Video Oficial.mp3",
                "Songs\\Christian Nodal  Te Fallé Video Oficial.mp3",
                "Songs\\De Morrito.mp3",
                "Songs\\DELINCUENTE  TOKISCHA x Anuel AA x Ñengo Flow Official Video.mp3",
                "Songs\\El Alfa El Jefe x CJ x El Cherry Scom  La Mamá de la Mamá Video Oficial.mp3",
                "Songs\\El Alfa x Darell x Noriel  4K Video Oficial.mp3",
                "Songs\\Grupo Marca Registrada Ft Junior H El Rescate Video Oficia.mp3",
                "Songs\\Jay Wheeler Ft El Alfa  No Confio Official Video.mp3",
                "Songs\\LUIS R CONRIQUEZPESO PLUMA  VIDEO OFICIAL SIEMPRE PENDIENTES.mp3",
                "Songs\\MOJA TOTO.mp3",
                "Songs\\Natanael Cano  Brillo Video Oficial.mp3",
                "Songs\\Natanael Cano  Diamantes Official Video.mp3",
                "Songs\\Natanael Cano  El Drip Official Video.mp3",
                "Songs\\Natanael Cano  Porte Exuberante ft Oscar Maydon Official Video.mp3",
                "Songs\\Normalito Remix.mp3",
                "Songs\\Rochy RD  El Coba  Vídeo Oficial.mp3",
                "Songs\\Rochy RD  Mi Contacto  Video Oficial.mp3",
                "Songs\\Si Fuera Fácil  Grupo Marca Registrada Official Video.mp3",
                "Songs\\Tokischa x ROSALÍA  Linda Official Video.mp3",
                "Songs\\Victor Cibrian  En El Radio Un Cochinero Official Video.mp3",
                "Songs\\Tan Soldao.mp3"


        };

        next_previous window = new next_previous(song);

        System.out.println(Arrays.toString(window.getFavoriteSongs()));
        System.out.println(window.getSongPlaying());
    }

    public next_previous(String[] song) {
        this.song = song;
        this.favoriteSongs = new int[song.length];
        for (int i = 0; i < song.length; i++) {
            this.favoriteSongs[i] = -1;
        }
        this.songPlaying = 0;
    }

    //Metodo para adelantas las canciones
    public void nextSong() {
        if (this.songPlaying >= 0 && this.songPlaying < (this.song.length - 1)) { //Revisa que se encuentre en una posicion dentro del rango de la lista de canciones
            this.songPlaying = this.songPlaying + 1; //Pasa a la siguiente cancion
        } else if (this.songPlaying >= this.song.length - 1) { //Revisa si el indice de las canciones es mayor al permitido
            this.songPlaying = (this.songPlaying + 1) % this.song.length; //Hace que salte al inicio de la lista
        }
    }

    //Metodo para devolver las canciones
    public void returnSong() {
        if (this.songPlaying == 0) { //Revisa que las canciones se encuentren en el rango de reproduccion
            this.songPlaying = (this.songPlaying + this.song.length - 1) % this.song.length; //Da un salto a la ultima cancion
        } else {
            this.songPlaying = this.songPlaying - 1; //Se devuelve una cancion
        }
    }

    public void newfavoriteSongs() {
        for (int i = 0; i < favoriteSongs.length; i++) { //Si la cancion favorita se esta reproduciondo da return
            if (favoriteSongs[i] == songPlaying)
                return; //Si es -1 la cancion no está agregada
            else if (favoriteSongs[i] == -1) { //Agrega la cancion a favoritas
                favoriteSongs[i] = songPlaying;
                return;
            }
        }
    }

    public String[] getSong() {
        return song;
    }

    public void setSong(String[] song) {
        this.song = song;
    }

    public int[] getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(int[] favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

    public int getSongPlaying() {
        return songPlaying;
    }

    public void setSongPlaying(int songPlaying) {
        this.songPlaying = songPlaying;
    }
}
