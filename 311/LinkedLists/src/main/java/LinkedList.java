package main.java;

public interface LinkedList {
    /**
     * @return This method returns the head of the list
     */
    Node getHead();

    /**
     * @return This method returns the number of elements stored in this list
     * */
    int getCount();

    /**
     * @return This method returns the node at the given index
     * */
    Node get(int index) throws IndexOutOfBoundsException;

    /**
     * This method should set the value at the given location
     * @param index the index of the location where the new value to be set
     * @param newValue the new value
     * @return the old value at the index
     * @throws IndexOutOfBoundsException Throws the exception when the index is out of bound
     */
    String set(int index, String newValue);

    /**
     * This method should add the given value to the end of the list
     * @param value This is the value to be added
     */
    void append(String value);

    /**
     * This method should insert the given value after the given node.
     * (We assume that the given node is in the list.)
     *
     * @param node This is the node after which the value should be inserted
     * @param value This is the value to be inserted
     */
    void insertAfter(Node node, String value) throws IllegalArgumentException;

    /**
     * This method should remove the given node in the list
     * (We assume that the given node is in the list.)
     *
     * All the values stored at/after the given index should be shifted forward by one index
     * For example, if the array has 3 elements stored at index 0, index 1, index 2
     * if we remove the element at index 0, the elements at index 1 and index 2 should be moved to index 0 and index 1
     * @param node the node to be removed
     * @return the value of the removed node
     */
    String remove(Node node) throws IllegalArgumentException;
}
