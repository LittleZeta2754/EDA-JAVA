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


    public void add(Song song) {

        Node n_node = new Node(song);
        Node tmp = this.head;
        //o(1)
        if (this.head == null) {
            this.head = n_node;
            return;
        }//O(N)
        else{
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(n_node);
        }
    }

    public void delete(Song song) {

        Node ret = null;
        Node tmp;
        if (this.head == null) {
            return;
        }
        if (this.head.getSong().compareTo(song) == 0) {
            ret = this.head;
            this.head = this.head.getNext();
            return;
        }
        for (tmp = this.head; tmp.getNext()!= null; tmp = tmp.getNext()) {
            if (tmp.getNext().getSong().(song) != 0) {
                ret = tmp.getNext();
                tmp.setNext(tmp.getNext().getNext());
                return;
            }
        }
        return;
    };

    public Song search(String title) {

        if (this.head == null) {
            return null;
        }else{

            Node tmp;
            for (tmp = this.head; tmp != null; tmp = tmp.getNext()) {
                if (tmp.getSong().getTitle().compareTo(title) == 0) {
                    return tmp.getSong();
                }
            }
            return null;
        }
    }


    public boolean isEmpty() {
        if (this.head == null){
            return true;
        }else {
            return false;
        }
    };

    public void print() {
        Node tmp;
        for (tmp = this.head; tmp != null; tmp = tmp.getNext()) {
            System.out.println(tmp.getSong() + "-");
        }
    };

};