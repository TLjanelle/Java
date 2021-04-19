package main.java;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A hash table that use chaining to resolve collisions.
 * */
abstract class HashTable<K, V> implements Table<K, V>  {
    private ArrayList<Item<K, V>>[] bucketArray;
    final int size = 1024;

    public HashTable(){
        // todo: please implement this method
    }

    abstract int hashFunction(K key);


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
    public void clear(){
        for (int i = 0; i < bucketArray.length; i++) {
            bucketArray[i].clear();
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
