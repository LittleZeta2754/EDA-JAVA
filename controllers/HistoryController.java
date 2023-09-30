package controllers;

import models.*;

public class HistoryController {
    private Stack history;

    public HistoryController() {
        this.history = new Stack();
    }
    
    public void anadirSong(Song song) { 
        this.history.push(song);
    }

    public String ultimaSong() {
        if(!this.history.isEmpty()) {
            return this.history.peek().getTitle();
        } else {
            return "No se han reproducido canciones";
        }
    } 
    public String buscarSongsPorID(String id) {      

        if(history.isEmpty()) {
            System.out.println("No hay canciones en la lista"); 
        }else{
            Song tmp;
            for( tmp= history.peek() ; tmp!=null; tmp= history.pop()) {
                if(tmp.getId().compareTo(id) == 0) {
                    return "Cancion con ese id encontrado: " + tmp;
                }
            }
        }
        return null;   
    }
        public void mostrarHistorialsong() { 
            Stack historyTemp = new Stack();
            System.out.println("HISTORIAL: ");
            System.out.println("================================");
            while(!history.isEmpty()){ 
                Song cancion = history.pop();
                historyTemp.push(cancion); 
                System.out.println("Cancion: " + cancion.getTitle()); 
                System.out.println("-----"); 
            }
            while(!historyTemp.isEmpty()) {  
                history.push(historyTemp.pop());

            }
    }
}