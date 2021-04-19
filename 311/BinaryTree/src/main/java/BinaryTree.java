package main.java;

import java.util.ArrayList;

/**
 * A binary tree, where each node has at most two children: left or right
 *
 * @param <V> the type of value that the node is going to store
 */
public class BinaryTree<V> {
    /**
     * the root node of the tree:
     * if the tree is empty, the root is null
     * otherwise, the root should be a main.java.Node reference
     */
    private Node<V> root;

    /**
     * The getter method for root.
     * @return the root of the tree
     */
    public Node<V> root(){
        return root;
    }

    /**
     * size: the number of nodes in the tree
     */
    private int size;

    /**
     * The getter method for size.
     * @return the size of the tree
     */
    public int size(){
        return size;
    }

    /**
     * The constructor for the binary tree
     * This method will build an empty tree.
     */
    public BinaryTree(){
        // todo: implement the constructor
        // initilize root to null
        this.root = null;

        // initialize size to 0
        this.size = 0;
    }

    /**
     * Add the first node into the tree.
     *
     * If the tree is not empty, return null.
     * If the tree is empty, create a node with the given value {@code element},
     * and make the newly created node as the root of the tree.
     *
     * @param element the value to be stored in the root node
     * @return the newly created root node if success; null if the tree already has a root
     */
    public Node<V> addRoot(V element){
        // Complete todo: replace the following line with your implementation
        if (this.root != null) return null;

        // create a node with the element
        Node<V> newNode = new Node(element, null);
        this.root = newNode;
        this.size++;
        return this.root;
    }

    /**
     * Add a left child to the {@code node}
     * If the node already has a left child, returns null.
     * If the node does not have a left child, create a new node with {@code element}
     * and add the newly created node as a left child of the current node.
     *
     * @param node the node where the left child will be added
     * @param element the left child will store the value {@code element}
     * @return the newly created left child if the {@code node} does not already have a left child
     */
    public Node<V> addLeftChild(Node<V> node, V element) {
        // Complete todo: replace the following line with your implementation
        if (node.isLeft()) return null;

        Node<V> newNode = new Node(element,node);
        node.left = newNode;
        this.size++;
        return node.left;
    }

    /**
     * Add a right child to the {@code node}
     * If the node already has a right child, returns null.
     * If the node does not have a right child, create a new node with {@code element}
     * and add the newly created node as a right child of {@code node}.
     *
     * @param node the node where the right child will be added
     * @param element the right child will store the value {@code element}
     * @return the newly created right child if the {@code node} does not already have a right child
     */
    public Node<V> addRightChild(Node<V> node, V element) {
        // Complete todo: replace the following line with your implementation
        if (node.isRight()) return null;
        Node<V> newNode = new Node(element,node);
        node.right = newNode;
        this.size++;
        return node.right;
    }

    /**
     * remove a node from the tree
     * if the node has two children, the node cannot be removed.
     * if the node has one child, let the child replace the node
     * if the node is root, the child will be the new root
     *
     * @param p the node to be removed
     * @return whether the node is removed or not
     */
    public boolean remove(Node<V> p){
        // todo: replace the following line with your implementation

        // Case `
        if (p.left != null && p.right !=null) return false;

        //Case 2
        Node<V> child = null;
        if (p.left != null) child  = p.left;
        if (p.right !=null) child = p.right;
        if (p.isLeft()) {
            p.parent.left = child;
            child.parent = p.parent;
        }
        if (p.isRight()) {
            p.parent.left = child;
            child.parent = p.parent;
        }

        // Case 3
        if (p.isLeft()) p.parent.left = null;
        if (p.isRight()) p.parent.right = null;
        if (p == this.root) this.root = null;

        this.size--;

        return false;
    }

    /**
     * Do a pre-order traversal on the binary tree, starting at node {@code p}
     * store the visited nodes in order in the list, {@code visited}
     *
     * @param p the node where we start visit
     * @param visited the list storing the visited nodes
     */
    private void preOrder(Node<V> p, ArrayList<Node<V>> visited){
        if (p == null) return;

        visited.add(p);
        preOrder(p.left, visited);
        preOrder(p.right, visited);
    }

    /**
     * @return the height of the whole tree
     */
    public int height(){
        if (root == null) {
            return -1;
        }

        return root.height();
    }

    /**
     * overrides toString method in Object class
     * @return a String that represents the tree
     */
    public String toString(){
        StringBuilder treeString = new StringBuilder();
        treeString.append("size: ");
        treeString.append(size);

        treeString.append("\nHeight of the tree is: ");
        treeString.append(this.height());

        if (root != null){
            treeString.append("\nroot: ").append(root).append("\n");
            // get the list of nodes in the pre-order
            ArrayList<Node<V>> preorderList = new ArrayList<>();
            preOrder(root, preorderList);

            for (Node<V> n : preorderList){
                // do an indentation based on the depth of the node
                int depth = n.depth();
                treeString.append(" ".repeat(Math.max(0, depth)));
                treeString.append(n+"\n");
            }
        }

        return treeString.toString();
    }
}
