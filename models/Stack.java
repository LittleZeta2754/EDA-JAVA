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
        Node newNode = new Node(song);
        if (isEmpty()){
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }        
    }

    // Saca una canción del top de la pila
    public Song pop() {
     if(!isEmpty()){
        Song sacarSong = top.getSong();
        top = top.getNext();
        return sacarSong;
     }else {
        return null;
        }
    }

    // "Mira" la canción del top de la pila
    public Song peek() {
        if(!isEmpty()){
            return top.getSong();
        } else {
            return null;
        }        
        
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return top == null;
        
    }

    // Imprime la pila
    public void print() {
        Node inicio = top;
        while(inicio !=null){
            System.out.println(inicio.getSong().toString());
            inicio = inicio.getNext();
    }
}
}