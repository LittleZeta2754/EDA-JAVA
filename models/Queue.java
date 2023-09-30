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


    public void enqueue(Song song) {
        Node n_Node = new Node(song);
        if(this.head == null && this.tail == null){
            this.head = this.tail = n_Node;
        } else{ 
            this.tail.setNext(n_Node);
            this.tail = n_Node;
        }
    }

    public void enqueuePrimer(Song song) {
        Node n_Node = new Node(song);
        if(this.head == null){
            this.tail = n_Node;
            this.head = n_Node;
        } else{ 
            n_Node.setNext(this.head);
            this.head = n_Node;
        }
    }


    public Song dequeue() {
        if(!this.isEmpty()){
            Song tmp = this.head.getSong();
            this.head = this.head.getNext();
            return tmp;
        }else{
            return null;
        }
    }

    public Song dequeueUltima() {
 
        if (this.isEmpty()) {
            return null;
        }
        else{
            Node prevNodo = this.head;

            while (prevNodo.getNext() != this.tail) {
                prevNodo = prevNodo.getNext();
            }

            Song tmp = this.tail.getSong();

            this.tail = prevNodo;
            prevNodo.setNext(null);

            return tmp;
        }
    }


    public Song peek() {
        Song peekSong = this.head.getSong();
        return peekSong;
    }


    public Song peekTail() {
        Song tailSong = this.tail.getSong();
        return tailSong;
    }


    public boolean isEmpty() {
        if (this.head == null){
            return true;
        }else {
            return false;
        }
    }

    public void print() { 
        Node tmp;
        for (tmp = this.head; tmp != null; tmp = tmp.getNext()) {
            System.out.println(tmp.getSong() + "-");
        }
    }
}