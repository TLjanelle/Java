package main.java;

public class DoublyLinkedList implements LinkedList {
    private DoublyLinkedListNode head; // the reference that points to the first node; is NULL if the list is empty
    private DoublyLinkedListNode tail; // the reference that points to the last node; is NULL if the list is empty
    private int count; // the count of the elements that the list stores

    public Node getHead() {return this.head;}
    public DoublyLinkedListNode getTail() {return this.tail;}

    /**
     * the class to represent Node in the list
     * DO NOT change this inner class
     * */
    public static class DoublyLinkedListNode extends Node {
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        public DoublyLinkedListNode(String value){
            super(value);
            this.next = null;
            this.prev = null;
        }

        public DoublyLinkedListNode getPrev() {
            return this.prev;
        }

        @Override
        public DoublyLinkedListNode getNext() {
            return this.next;
        }
    }

    /**
     * DO NOT change this constructor
     * This constructor initialize the instance variables
     */
    public DoublyLinkedList(){
        count = 0;
        head = null;
        tail = null;
    }

    /**
     * DO NOT change this method
     * @return This method returns the current number of elements stored in this list
     * */
    @Override
    public int getCount() {return this.count;}

    /* COMPLETED: implement this method */
    @Override
    public Node get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index out of Bounds.");
        }

        DoublyLinkedListNode n = this.head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /* COMPLETED: implement this method */
    @Override
    public String set(int index, String newValue) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index Out of Bounds.");
        }
       // DoublyLinkedListNode n = this.head;

        DoublyLinkedListNode newNode = (DoublyLinkedListNode) get(index);
        String oldValue = get(index).getValue();

        newNode.setValue(newValue);
        return oldValue;
    }

    /* COMPLETED: implement this method */
    @Override
    public void append(String value) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(value);

        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            DoublyLinkedListNode lastNode = this.tail;
            lastNode.next = newNode;
            newNode.prev = lastNode;
            this.tail = newNode;
        }
        this.count++;

    }

    /* Todo: implement this method */
    @Override
    public void insertAfter(Node node, String value) throws IllegalArgumentException {
        if (!(node instanceof DoublyLinkedListNode)) {
            throw new IllegalArgumentException("The given node is not DoublyListNode");
        }

        DoublyLinkedListNode targetNode = (DoublyLinkedListNode) node;

        // if given node is the last node, invoke append()
        if (targetNode == this.tail) {
            append(value);
        } else {
            // Create a new node with the given value
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(value);
            DoublyLinkedListNode targetNext = targetNode.next;
            targetNode.next = newNode;
            newNode.prev = targetNode;
            newNode.next = targetNext;
            targetNext.prev = newNode;
            // Set the new node’s prev to the target
            //newNode.prev = targetNode;

            // Set the new node’s next to the targetNext
            //newNode.next = targetNode.next;

            // Set the targetN’s next to the new node
            //targetNode.next = newNode;

            // Set the targetNext’s prev to the new node
            //targetNode.next = newNode;

            // Increment count by one
            this.count++;
        }
    }

    /* Todo: implement this method */
    @Override
    public String remove(Node node) throws IllegalArgumentException {
        if (!(node instanceof DoublyLinkedListNode)) {
            throw new IllegalArgumentException("The given node is not DoublyListNode");
        }

        DoublyLinkedListNode targetN = (DoublyLinkedListNode) node;

        // if targetN is the head and the tail
        if (targetN == this.head && targetN == this.tail) {
            // Set the head to null
            this.head = null;
            // Set the tail to null
            this.tail = null;
        } else if (targetN == this.head) {
            // Set the head to the targetNext
            this.head = targetN.next;
            // targetNext’s prev to null
            targetN.next.prev = null;
        } else if (targetN == tail) {
            // set the tail to the targetPrev
            this.tail = targetN.prev;
            // targetPrev’s next to null
            targetN.prev.next = null;
        } else {
            // set targetPrev next to targetNext
            targetN.prev.next = targetN.next;
            // set targetNext’s prev to targetPrev
            targetN.next.prev = targetN.prev;
        }
        // Decrement the count by one
        this.count--;
        return targetN.getValue();
    }
}
