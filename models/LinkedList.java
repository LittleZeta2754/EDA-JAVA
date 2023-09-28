package models;

import javax.swing.text.StyledEditorKit;

interface LinkedListInterface {
    // Agrega una canción al final de la lista
    public void add(Song song);

    // Elimina una canción específica de la lista
    public void delete(Song song);

    // Buscar una canción por título
    public Song search(String title);

    // Revisa si la lista está vacía
    public boolean isEmpty();

    // Imprimir todas las canciones
    public void print();
}

public class LinkedList implements LinkedListInterface {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Agrega una canción al final de la lista
    public void add(Song song) {
        Node newNode = new Node(song);
        if (head == null){
            head = newNode;
        } else {
            Node inicio = head;
            while (inicio.getNext() != null){
                inicio = inicio.getNext();
            }
            inicio= newNode;
        }
    }

    // Elimina una canción específica de la lista
    public void delete(Song song) {
        if (this.head == null){
            return;
        }
        Node inicio = this.head;
        while (inicio.getNext() != null){
            if (inicio.getNext().equals(song)){
                inicio = inicio.getNext().getNext();
                return;
            }
            inicio = inicio.getNext();
        }
    }

    // Buscar una canción por título
    public Song search(String title) {
        Node inicio = this.head;
        while (inicio != null){
            if (inicio.getSong().getTitle().equals(title)){
                return inicio.getSong();
            }else{
                System.out.println("No esta papu esa cancion");
                break;

            }
             
        }
        return null;
    }

    // Revisa si la lista está vacía
    public boolean isEmpty() {
       return head == null;
    }

    // Imprimir todas las canciones
    public void print() {
        Node inicio = head;
        while (inicio != null) {
            System.out.println(inicio.toString());
            inicio = inicio.getNext();
    }
}
}