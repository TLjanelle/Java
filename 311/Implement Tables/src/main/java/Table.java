package main.java;

/**
 * The interface for the abstract data type, Table
 * ElementaryTable and HashTable are two different implementations for the same interface.
 *
 * @param <K> the type for keys
 * @param <V> the type for values
 */
public interface Table<K, V> {
    /**
     * Add a pair of (key, value) to the table.
     * The value cannot be null.
     * If the key is already in the table, overwrite the existing value with the new value.
     *
     * (The parameters and the return value are copied from the openjdk implementation of HashMap)
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     */
    V put(K key, V value);

    /**
     * Get the value for the key in the table
     * If the key is not in the table, returns null
     *
     * @param key the key
     * @return the corresponding value for {@code key}. NULL if the key cannot be found.
     */
    V get(K key);

    /**
     * Delete the key-value pair in the table
     *
     * (The parameters and the return value are copied from the openjdk implementation of HashMap)
     *
     * @param  key key whose mapping is to be removed from the map
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     */
    V remove(K key);

    /**
     * Check if the table has the key.
     *
     * (The parameters and the return value are copied from the openjdk implementation of HashMap)
     *
     * @param   key   The key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     * key.
     */
    boolean containsKey(K key);

    /**
     * Clear the table: remove all the key-value pairs from the table.
     *
     * This method is a utility method for testing.
     */
    void clear();

    /**
     * Override the object's toString method
     *
     * This method is a utility method for testing.
     */
    String toString();

}
