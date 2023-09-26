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
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Sacar una canción del frente de la cola. retorna la canción y la elimina el nodo.
    public Song dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T item = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return item;
    }

    // "Mirar" la canción del frente de la cola
    public Song peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return head.data;
    }

    // "Mirar" la canción del final de la cola
    public Song peekTail() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return tail.data;
    }

    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // Imprimir la cola
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}