package models;

interface NodeInterface {
    // Getters
    public Song getSong();
    public Node getNext();

    // Setters
    public void setSong(Song song);
    public void setNext(Node next);
}

public class Node implements NodeInterface{
    private Song song;
    private Node next;

    public Node(Song song) {
        this.song = song;
        this.next = null;
    }

    // Getters
    public Song getSong() {
        return this.song;
    }
    public Node getNext() {
        return this.next;
    }

    // Setters
    public void setSong(Song song) {
        this.song = song;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    
}
