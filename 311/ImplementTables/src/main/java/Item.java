package main.java;

/**
 * The data structure to store a pair of key and value.
 */
class Item<K, V> {
    K key;
    V value;

    Item(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
