package main.java;

public class HashTableSimpleHash<K,V> extends HashTable<K,V> {
    /**
     * prehash: to map an object to an integer
     * */
    private int prehash(K key) {
        // this key.hashCode method will return an integer for a given key.
        // The range of this "hash code" is the range of int
        // This is prehash although it's called hashCode in Java.
        return Math.abs(key.hashCode());
    }

    /**
     * This is the naive hashing discussed in the lecture.
     */
    private int hashing(int key) {
        int hashKey = key % size;
        return hashKey;
    }

    /**
     * This is the hash function calls prehash and hashing
     * @param key the key
     * @return the hash code for array indexing
     */
    int hashFunction(K key) {
        int preHashCode = prehash(key);
        return hashing(preHashCode);
    }
}
