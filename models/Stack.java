package models;

interface StackInterface {
    // Inserta una canción en el top de la pila
    public void push(Song song);

    // Saca una canción del top de la pila
    public Song pop();

    // "Mira" la canción del top de la pila
    public Song peek();

    // Verifica si la pila está vacía
    public boolean isEmpty();

    // Imprime la pila
    public void print();
}

public class Stack implements StackInterface {
    private Node top;

    public Stack() {
        this.top = null;
    }


    public void push(Song song) {
        Node n_Node = new Node(song);
        if(this.top == null){
            this.top = n_Node;
        }else{
            this.top.setNext(n_Node);
            this.top = n_Node;
        }
    }

    public Song pop() {
        if(this.top != null){
            this.top = this.top.getNext();
        }
        return null;
    }


    public Song peek() {
        Song topSong = this.top.getSong();
        return topSong;
    }

    public boolean isEmpty() {
        if(this.top == null){
            return true;
        }else{
            return false;
        }
    }

    public void print() {
        Node aux = this.top;
        while(aux!= null){
            System.out.println(aux.getSong());
            aux = aux.getNext();
        } 
    }
}