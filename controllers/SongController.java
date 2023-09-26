package controllers;

import models.*;

public class SongController {
    private LinkedList songList;

    public SongController() {
        this.songList = new LinkedList();
    }

    public void addSong(Song song) {
        this.songList.add(song);
    }

    /* Complementar con funciones faltantes! */

}
