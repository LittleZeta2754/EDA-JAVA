package models;

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
            while (inicio.next != null){
                inicio = inicio.next;
            }
            inicio.next = newNode;
        }
    }

    // Elimina una canción específica de la lista
    public void delete(Song song) {
        if (head == null){
            return
        }
        Node inicio = head;
        while (inicio.next != null){
            if (inicio.next.data.equals(song)){
                inicio.next = inicio.next.next;
                return;
            }
            inicio = inicio.next;
        }
    }

    // Buscar una canción por título
    public Song search(String title) {
        Node inicio = head;
        while (inicio != null){
            if (inicio.data.getTitle().equals(title)){
                return inicio.data;
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
            System.out.println(inicio.data.toString());
            inicio = inicio.next;
    }
}