package com.example.codigo;

import java.util.Arrays;

public class next_previous {
    private String[] song;
    private int[] favoriteSongs;
    private int songPlaying;

    public static void IDSong(String[] args) {
        String[] song = {
                "Mil horas",
                "Por ese hombre",
                "A esa",
                "Algo de mi",
                "Si me dejas ahora",
                "¿Quieres ser mi amante?",
                "Quel sorrito in volto",
                "per una notte insieme",
                "Como un pintor",
                "Sencillamente",
                "Un segundo",
                "Enciéndeme",
                "Cuando me enamoro",
                "Tu eres mi tesoro",
                "Piccola anima",
                "Solo a ti pertenezco",
                "Todos por todos"
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
