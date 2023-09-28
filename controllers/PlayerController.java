package controllers;

import models.Queue;
import models.Song;

public class PlayerController {
    private Queue playlist;

    public PlayerController() {
        this.playlist = new Queue();
    }
    public void addToPlaylist(Song song) {
        this.playlist.enqueue(song);
    }
    public Song playNext() {
        return this.playlist.dequeue();
    }
    public Song getNextInPlaylist() {
        return this.playlist.peek();
    }

    /* Complementar con funciones faltantes! */
}
