package controllers;

import models.Stack;
import models.Song;

public class HistoryController {
    private Stack historyStack;

    public HistoryController() {
        this.historyStack = new Stack();
    }
    public void addToHistory(Song song) {
        this.historyStack.push(song);
    }
    public Song removeFromHistory() {
        return this.historyStack.pop();
    }
    public Song viewLastPlayedSong() {
        return this.historyStack.peek();
    }
    public boolean isHistoryEmpty() {
        return this.historyStack.isEmpty();
    }
    public void printHistory() {
        System.out.println("Historial de canciones reproducidas:");
        this.historyStack.print();
    }
}
 
    /* Complementar con funciones faltantes! */