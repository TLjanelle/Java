package main.java;

import java.util.ArrayList;

public class ElementaryTable<K, V> implements Table<K, V> {

    private ArrayList<Item<K, V>> list;

    public ElementaryTable() {
        list = new ArrayList<>();
        list.size();
    }

    private Item<K, V> findItem(K key) {
        for (Item<K, V> item : this.list) {
            if (item.key.equals(key)) return item;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        // first check if key is in the table
        Item<K, V> found = findItem(key);
        // if key is in the table: we update the value of the key with value (return the previous value)
        if (found != null) {
            V oldValue = found.value;
            found.value = value;
            return oldValue;
        } else {
            // if key is not in the table: we add the pair of key and value to the table (return null)
            Item<K, V> newItem = new Item<>(key, value);
            this.list.add(newItem);
            return null;
        }
    }

    @Override
    public V get(K key) {
        Item<K, V> found = findItem(key);
        // check if the key is in the table
        if (found != null) {
            // If key is in the table: return the value
            return found.value;
        }
        // else return null
        return null;
    }

    @Override
    public V remove(K key) {
        // check if the key is in the table
        Item<K, V> found = findItem(key);
        // If key is in the table: remove the key and value(return the value)
        if (found != null) {
            V oldValue = found.value;
            list.remove(found);
            return oldValue;
        }
        // else return null
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        // check if the key is in the table,
        Item<K, V> found = findItem(key);
        // if the key is in the table, return true
        return found != null;
    }

    @Override
    public void clear() {
        // removes all the elements in the list
        list.clear();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        for (Item<K, V> item : list) {
            stringBuilder.append(item.key).append("->").append(item.value).append(", ");
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
