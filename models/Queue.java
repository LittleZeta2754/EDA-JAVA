package models;

interface QueueInterface {
    // Añadir una canción al final de la cola (rear)
    public void enqueue(Song song);

    // Sacar una canción del frente de la cola. retorna la canción y la elimina el nodo.
    public Song dequeue();

    // "Mirar" la canción del frente de la cola
    public Song peek();

    // "Mirar" la canción del final de la cola
    public Song peekTail();

    // Verificar si la cola está vacía
    public boolean isEmpty();

    // Imprimir la cola
    public void print();
}

public class Queue implements QueueInterface {
    private Node head;
    private Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    // Añadir una canción al final de la cola (rear)
    public void enqueue(Song song) {
    }

    // Sacar una canción del frente de la cola. retorna la canción y la elimina el nodo.
    public Song dequeue() {
        return null;
    }

    // "Mirar" la canción del frente de la cola
    public Song peek() {
        return null;
    }

    // "Mirar" la canción del final de la cola
    public Song peekTail() {
        return null;
    }

    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return true;
    }

    // Imprimir la cola
    public void print() {
    }
}