package main.java;

import org.w3c.dom.Node;

import java.util.EmptyStackException;

public class Stack {
    DoublyLinkedList list;

    /**
     * This constructor initialize the instance variables
     */
    public Stack(){
        /* the list that's going to store the elements */
        list = new DoublyLinkedList();
    }

    /**
     * COMPLETED: implement this method
     * This method should add the given value to the stack
     * @param newValue This is the value to be added
     */
    public void push(String newValue){
        list.append(newValue);
    }

    /**
     * COMPLETED: implement this method
     * @return returns the most recently added element
     * @throws EmptyStackException Throws this exception if the stack is empty
     */
    public String top() {
        if (this.empty()) {
            throw new EmptyStackException();
        } else {
            return list.getTail().getValue();
        }
    }

    /**
     * COMPLETED: implement this method
     * @return removes and returns the most recently added element
     * @throws EmptyStackException throws an exception when the stack is empty
     */
    public String pop() throws EmptyStackException {
        if (this.empty()) {
            throw new EmptyStackException();
        } else return list.remove(list.getTail());
    }

    /**
     * COMPLETED: implement this method
     * @return whether the stack is empty or not
     */
    public boolean empty() {
        return list.getCount() == 0;
    }

    /**
     * This is a utility method for testing.
     */
    public int size() {
        return list.getCount();
    }

}
