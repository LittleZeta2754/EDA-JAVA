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

    public void borrarSong(Song song) {
        this.songList.delete(song);
    } 

    public Song buscarSong(String title) {
        long start = System.nanoTime();
        return this.songList.search(title);
        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("Buscada titulo demoró: " + duration + "ms");
    }

}