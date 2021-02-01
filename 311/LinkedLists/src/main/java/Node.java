package main.java;

public abstract class Node {
    private String value;

    public String getValue() {return value;}
    public void setValue(String newValue) {this.value = newValue;}
    public Node(String value) {
        this.value = value;
    }
    public abstract Node getNext();
}
