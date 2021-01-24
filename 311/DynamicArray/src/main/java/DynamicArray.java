package main.java;

public class DynamicArray {
    private String[] array;
    private int count;

    /**
     * The getter method for the count of elements in the array
     **/
    public int getCount() {
        return count;
    }

    /**
     * The getter method for the capacity (the size of the array)
     **/
    public int getCapacity() {
        return this.array.length;
    }

    /**
     * TODO: implement this method
     * This constructor should initiate the class fields (i.e., this.array and this.count) appropriately.
     * @param initialSize the initial size for the array
     * @throws IllegalArgumentException Throws the exception when the initial size is not greater than 0
     */
    public DynamicArray(int initialSize) throws Exception {

    }

    /**
     * TODO: implement this method
     * This method should change the size of the array to the given size
     * @param newSize This is the target size that the array should be changed to
     * @throws IllegalArgumentException Throws this exception if
     * the new size is smaller than the current number of elements stored in the array
     **/
    private void resize(int newSize) throws Exception {
    }

    /**
     * TODO: implement this method
     * This method should return the value stored at the given index.
     * @param index The given index that points to the location where the method will get the value from
     * @return the value at index in the array
     * @throws IndexOutOfBoundsException Throws the exception when the index is out of bound
     */
    public String get(int index) {
        return null;
    }

    /**
     * TODO: implement this method
     * This method should set the value
     * @param index the index of the location where the new value to be set
     * @param newValue the new value
     * @return the old value at the index
     * @throws IndexOutOfBoundsException Throws the exception when the index is out of bound
     */
    public String set(int index, String newValue) {
        return null;
    }

    /**
     * TODO: implement this method
     * This method should add the given value to the end of the array
     * If the array is full before adding the value, the dynamic array should double the capacity
     * @param value This is the value to be added
     * @return the index of the location where the value is stored
     */
    public int append(String value) throws Exception {
        return -1;
    }

    /**
     * TODO: implement this method
     * This method should insert the given value at given index.
     * All the values stored at/after the given index should be shifted back by one index
     * All the elements of the array should be stored consecutively and always from index 0.
     * For example, if the array has 2 elements stored at index 0 and index 1,
     * the insert method can insert a value at index 0 and 1.
     * But the insert method cannot insert a value at index 2.
     *
     * If the array is full before the insertion, the dynamic array should double the capacity
     *
     * @param index This is the index that specifies the position where the value should be inserted
     * @param value This is the value to be inserted
     * @throws IndexOutOfBoundsException Throws this exception if the index is out of the bounds
     */
    public void insert(int index, String value) throws Exception {
    }

    /**
     * TODO: implement this method
     * This method should remove the element at the given index position
     * All the values stored at/after the given index should be shifted forward by one index
     * For example, if the array has 3 elements stored at index 0, index 1, index 2
     * if we remove the element at index 0, the elements at index 1 and index 2 should be moved to index 0 and index 1
     * @param index This is the index that specifies the position where the element should be removed
     * @return the value of the removed value
     * @throws IndexOutOfBoundsException Throws the exception when the array is empty
     */
    public String remove(int index) throws IndexOutOfBoundsException {
        return null;
    }
}
