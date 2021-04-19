package main.java;

import java.util.ArrayList;

/**
 * A hash table that use chaining to resolve collisions.
 * */
abstract class HashTable<K, V> implements Table<K, V>  {
    private ArrayList<Item<K, V>>[] bucketArray;
    final int size = 1024;

    public HashTable(){
        // COMPLETED: please implement this method

        // Create an Array to hold an element of Array List
        bucketArray = new ArrayList[size];
        // Instantiate the list
        for (int i = 0; i < bucketArray.length; i++) {
            bucketArray[i] = new ArrayList<>();
        }
    }

    abstract int hashFunction(K key);

    private Item<K, V> findItem(ArrayList<Item<K, V>> list, K key) {
        for (Item<K, V> item : list) {
            if (item.key.equals(key)) return item;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        // get the hash code
        int hashCode = hashFunction(key);
        ArrayList<Item<K, V>> list = this.bucketArray[hashCode];

        // find the list
        Item<K, V> item = this.findItem(list, key);

        // add the item to the list
        if (item == null) {
            list.add(new Item<>(key, value));
            return null;
        } else {
            V oldValue = item.value;
            item.value = value;
            return oldValue;
        }
    }

    @Override
    public V get(K key) {
        // get the hash code
        int hashCode = hashFunction(key);
        ArrayList<Item<K, V>> list = this.bucketArray[hashCode];

        // find the list
        Item<K, V> item = this.findItem(list, key);

        //get the item from the list
        if (item == null) {
            return null;
        } else {
            return item.value;
        }
    }

    @Override
    public V remove(K key) {
        // get the hash code
        int hashCode = hashFunction(key);
        ArrayList<Item<K, V>> list = this.bucketArray[hashCode];

        // find the list
        Item<K, V> item = this.findItem(list, key);

        // remove the item from the list
        if (item == null) {
            return null;
        } else {
            V oldValue = item.value;
            list.remove(item);
            return oldValue;
        }
    }

    @Override
    public boolean containsKey(K key) {
        // get the hash code
        int hashCode = hashFunction(key);
        ArrayList<Item<K, V>> list = this.bucketArray[hashCode];

        // find the list
        Item<K, V> item = this.findItem(list, key);

        return item != null;
    }

    @Override
    public void clear(){
        for (ArrayList<Item<K, V>> items : bucketArray) {
            items.clear();
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        int maxBucketSize = 0;
        int sumBucketSize = 0;
        int nonEmptyBucketCount = 0;
        for (int i = 0; i < bucketArray.length; i++) {
            ArrayList<Item<K,V>> list = bucketArray[i];
            stringBuilder.append("bucket ").append(i).append(": ");
            for (Item<K, V> item : list) {
                stringBuilder.append(item.key).append("->").append(item.value).append(", ");
            }
            stringBuilder.append("\n");

            if (list.size() > maxBucketSize) {
                maxBucketSize = list.size();
            }
            sumBucketSize += list.size();
            if (list.size() > 0) {
                nonEmptyBucketCount++;
            }
        }

        stringBuilder.append("max bucket size: ").append(maxBucketSize).append("\n");
        stringBuilder.append("average non-empty bucket size: ").append(sumBucketSize/nonEmptyBucketCount);

        return stringBuilder.toString();
    }
}
