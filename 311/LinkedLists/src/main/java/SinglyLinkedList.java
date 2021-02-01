package main.java;

public class SinglyLinkedList implements LinkedList {
    private SinglyLinkedListNode head; // the reference that points to the first node; is NULL if the list is empty
    private int count; // the count of the elements that the list stores

    /**
     * DO NOT  change this method
     */
    @Override
    public SinglyLinkedListNode getHead() {
        return this.head;
    }

    /**
     * the class to represent Node in the list
     * DO NOT change this inner class
     */
    public static class SinglyLinkedListNode extends Node {
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(String value) {
            super(value);
            this.next = null;
        }

        @Override
        public SinglyLinkedListNode getNext() {
            return this.next;
        }
    }

    /**
     * DO NOT change this constructor
     * This constructor initialize the instance variables
     */
    public SinglyLinkedList() {
        this.count = 0;
        this.head = null;
    }

    /**
     * DO NOT change this method
     *
     * @return This method returns the current number of elements stored in this list
     */
    @Override
    public int getCount() {
        return this.count;
    }

    /* COMPLETE: implement this method */
    @Override
    public Node get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index out of Bounds.");
        }

        SinglyLinkedListNode n = this.head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /* COMPLETED: implement this method */
    @Override
    // Set the value to the index at the position
    public String set(int index, String newValue) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index Out of Bounds.");
        }
        SinglyLinkedListNode n = this.head;

        SinglyLinkedListNode newNode = (SinglyLinkedListNode) get(index);
        String oldValue = get(index).getValue();

        newNode.setValue(newValue);
        return oldValue;
    }

    /* COMPLETED: implement this method */
    @Override
    public void append(String value) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);

        if (this.count == 0) {
            this.head = newNode;
        } else {
            SinglyLinkedListNode n = this.head;
            for (int i = 0; i < this.count - 1; i++) {
                n = n.next;
            }
            n.next = newNode;
        }
        this.count++;
    }

    /* COMPLETED: implement this method */
    @Override
    public void insertAfter(Node node, String value) throws IllegalArgumentException {
        if (!(node instanceof SinglyLinkedListNode)) {
            throw new IllegalArgumentException("The given node is not SinglyListNode");
        }

        SinglyLinkedListNode node1 = (SinglyLinkedListNode) node;
        //Create new node with value
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
        //newNode points to node2
        newNode.next = node1.next;
        //node1 points to newNode
        node1.next = newNode;

        this.count++;
    }

    /* COMPLETED: implement this method */
    @Override
    public String remove(Node node) throws IllegalArgumentException {
        if (!(node instanceof SinglyLinkedListNode)) {
            throw new IllegalArgumentException("The given node is not SinglyListNode");
        }

        SinglyLinkedListNode node1 = (SinglyLinkedListNode) node;

        SinglyLinkedListNode prev_temp;
        SinglyLinkedListNode temp;

        if (node1 == this.head) {
            this.head = head.next;
        } else {
            prev_temp = this.head;
            temp = head.next;
            while (temp != node1) {
                temp = temp.next;
                prev_temp = prev_temp.next;
            }
            prev_temp.next = temp.next;
        }
        this.count--;
        return node1.getValue();
    }
}