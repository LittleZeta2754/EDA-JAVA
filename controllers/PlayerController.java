package controllers;

import models.Queue;
import models.Song;

public class PlayerController {
    private Queue playlist;

    public PlayerController() {
        this.playlist = new Queue();
    }

    public void AgregarSong(Song song){  
            playlist.enqueue(song);
    }

    public void ReproducirNextSong() {
        if(!playlist.isEmpty()){
            playlist.dequeue();
        }else{
            System.out.println("No hay canciones despues de esta en la lista de reproducción."); 
        }
    } 

    public void VerNextSong() {
        if(!playlist.isEmpty()) { 
            playlist.peek();
        }else{
            System.out.println("No hay mas canciones en la lista de reproducción.");     
        }
    }

    public void EliminarSong(Song song) {
            playlist.dequeue();
    }


    public void cambiarOrdenSong(Song song1, Song song2) { 
        Queue newPlaylist = new Queue();
        Song cancionTemp = null;

        while (!playlist.isEmpty()) {
            Song cancionActual = playlist.dequeue();
            if(cancionActual.compareTo(song1) == 0){
                if(cancionTemp == null) {
                    cancionTemp = cancionActual;
            }else if(cancionActual.compareTo(song2) == 0){
                if(cancionTemp != null){ 
                    newPlaylist.enqueue(song2);
                    newPlaylist.enqueue(cancionTemp);
                    cancionTemp = null;
                } 
            }else{
                newPlaylist.enqueue(cancionActual);
            }
        }
        playlist = newPlaylist;
    }
}

    
    public void cambiarOrdenPrimeraAUltimaSong() {
        long start = System.nanoTime();
        System.out.println("Primera cancion actual: " + playlist.peek());
        System.out.println("Ultima cancion actual: " + playlist.peekTail());
        if(!playlist.isEmpty()) {
            Song primerCancion = playlist.peek();
            playlist.enqueue(primerCancion);
            playlist.dequeue();
            System.out.println("Se ha cambiado el orden de la lista");
            System.out.println("Nuevo orden de la lista: \n");
            System.out.println("Nueva primera cancion: " + playlist.peek());
            System.out.println("Nueva ultima cancion: " + playlist.peekTail());
        }else{ 
            System.out.print("No hay canciones en la lista de reproducción.");
        }
        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("\n Se demoró en cambiar el orden: " + duration + "ms");
    }

   
    public void cambiarOrdenUltimaAPrimeraSong() {
        long start = System.nanoTime();
        System.out.println("Primera cancion actual: " + playlist.peek());
        System.out.println("Ultima cancion actual: " + playlist.peekTail());
        if(!playlist.isEmpty()) {
            Song ultimaSong = playlist.peekTail();
            playlist.enqueuePrimer(ultimaSong);
            playlist.dequeueUltima();
            System.out.println("Se ha cambiado el orden de la lista");
            System.out.println("Nuevo orden de la lista: \n");
            System.out.println("primera cancion: " + playlist.peek());
            System.out.println("Ultima cancion: " + playlist.peekTail());
        }else{ 
            System.out.print("No hay canciones en la lista de reproducción.");
        }
        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("\n Tiempo en cambiar el orden " + duration + "ms");
    }
    

}