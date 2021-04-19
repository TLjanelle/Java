package main.java;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HashTableUniversalHash<K,V> extends HashTable<K,V> {
    // long a = ThreadLocalRandom.current().nextLong(3147485713L);
    // long b = ThreadLocalRandom.current().nextLong(3147485713L);


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
     * This is the basic universal hashing discussed in the lecture.
     */
    private int hashing(int key) {
         long p = 3147485713L;  // prime number that's bigger than the key range for int range, 2147483647

        Random rand = new Random();

        // long a = rand.nextInt(p - 1);  // random number less than p
        // long b = rand.nextInt(p - 1);  // random number less than p

        long a = 859026201L;
        long b = 1876304068L;

        // The hash function is: h(key) = [ (a * key + b) mod p ] mod m
        long universalHashKey = ((a * key + b) % p) % size;

        return Math.abs((int) universalHashKey);
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
