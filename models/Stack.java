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

    // Inserta una canción en el top de la pila
    public void push(Song song) {
    }

    // Saca una canción del top de la pila
    public Song pop() {
        return null;
    }

    // "Mira" la canción del top de la pila
    public Song peek() {
        return null;
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return true;
    }

    // Imprime la pila
    public void print() {
    }
}