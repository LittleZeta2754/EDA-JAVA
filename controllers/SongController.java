package controllers;

import models.LinkedList;
import models.Song;

public class SongController {
    private LinkedList songList;

    public SongController() {
        this.songList = new LinkedList();
    }

    public void addSong(Song song) {
        this.songList.add(song);
    }

    /* Complementar con funciones faltantes! */

   public Song searchSong(String title){
        return this.songList.search(title);
        
   } 

   
}
