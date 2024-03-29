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
    Node<V> left; //points to left child of the current node
    Node<V> right; //points to the right child

    /**
     * Constructor for main.java.Node
     *
     * @param element the value to store in the node
     * @param parent the parent of the node
     */
    public Node(V element, Node<V> parent){
        // COMPLETED todo: implement the constructor

        // initialize element, parent, left, & right
        this.element = element;
        this.parent = parent;
        left = null;
        right = null;
    }

    /**
     * @return whether the node is a left child of its parent
     */
    public boolean isLeft(){
        // COMPLETED todo: replace the following line with your implementation


        return this.parent != null && this.parent.left == this;
    }

    /**
     * @return whether the node is a right child of its parent
     */
    public boolean isRight(){
        // COMPLETED todo: replace the following line with your implementation
        return this.parent !=null && this.parent.right == this;
    }

    /**
     * This method calculate the depth of {@code node} in the tree
     *
     * @return the depth of the node
     */
    public int depth(){
        // COMPLETED todo: replace the following line with your implementation
        if (this.parent == null) return 0;
        return 1 + this.parent.depth();
    }

    /**
     * This method calculate the height of the node
     *
     * @return the height of the node
     */
    public int height() {
        // COMPLETED todo: replace the following line with your implementation
        if (this.isExternal()) return 0;

        int leftHeight = 0;
        int rightHeight = 0;
        if (this.left != null) leftHeight = this.left.height() + 1;
        if (this.right != null) rightHeight = this.right.height() + 1;

        int maxHeight = Math.max(leftHeight, rightHeight);
        
        return maxHeight;
    }

    private boolean isInternal() {
        return left != null || right!= null;
    }

    private boolean isExternal() {
        return !isInternal();
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
