package main.java;

import java.util.ArrayList;

public class ElementaryTable<K, V> implements Table<K, V> {

    private ArrayList<Item<K, V>> list;

    public ElementaryTable() {
        // please implement this method
    }


    @Override
    public V put(K key, V value) {
        // please replace the following line with your implementation
        return null;
    }

    @Override
    public V get(K key) {
        // please replace the following line with your implementation
        return null;
    }

    @Override
    public V remove(K key) {
        // please replace the following line with your implementation
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        // please replace the following line with your implementation
        return false;
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
