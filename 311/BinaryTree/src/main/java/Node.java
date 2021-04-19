package main.java;

/**
 * main.java.Node class for binary trees
 * @param <V> the type of value that the node is going to store
 */
public class Node<V> {
    /**
     * element: the instance variable that holds the value of the node
     */
    V element;
    public V getElement(){return element;}

    Node<V> parent;
    public Node<V> getParent(){return parent;}
    Node<V> left;
    Node<V> right;

    /**
     * Constructor for main.java.Node
     *
     * @param element the value to store in the node
     * @param parent the parent of the node
     */
    public Node(V element, Node<V> parent){
        // todo: implement the constructor
    }

    /**
     * @return whether the node is a left child of its parent
     */
    public boolean isLeft(){
        // todo: replace the following line with your implementation
        return false;
    }

    /**
     * @return whether the node is a right child of its parent
     */
    public boolean isRight(){
        // todo: replace the following line with your implementation
        return false;
    }

    /**
     * This method calculate the depth of {@code node} in the tree
     *
     * @return the depth of the node
     */
    public int depth(){
        // todo: replace the following line with your implementation
        return -1;
    }

    /**
     * This method calculate the height of the node
     *
     * @return the height of the node
     */
    public int height() {
        // todo: replace the following line with your implementation
        return -1;
    }

    /**
     * overrides toString method in Object class
     * @return a String that represents the node
     */
    public String toString(){
        String nodeString = "";
        if (this.isLeft()){
            nodeString += "l:";
        } else if (this.isRight()){
            nodeString += "r:";
        }
        if (this.element == null){
            return nodeString + "(null)";
        } else {
            return nodeString + this.element.toString();
        }
    }
}
