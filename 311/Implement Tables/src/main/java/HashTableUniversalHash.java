package main.java;

public class HashTableUniversalHash<K,V> extends HashTable<K,V> {
    /**
     * prehash: to map an object to an integer
     * */
    private int prehash(K key) {
        // this key.hashCode method will return an integer for a given key.
        // The range of this "hash code" is the range of int
        // This is prehash although it's called hashCode in Java.
        return key.hashCode();
    }

    /**
     * This is the basic universal hashing discussed in the lecture.
     */
    private int hashing(int key) {
        // please replace the following line with your implementation
        return -1;
    }

    int hashFunction(K key) {
        // please replace the following line with your implementation
        return -1;
    }
}
