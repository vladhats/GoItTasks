package HW9;

import java.util.LinkedList;
import java.util.Set;

import static java.util.Objects.hash;

public class MyHashMap<K, V> implements BasicMap<K, V> {
    private final static int DEFAULT_INITIAL_CAPACITY = 4;
    private final static int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;
    private final static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    private float loadFactorThreshold;
    private int size = 0;
    LinkedList<Entry<K, V>>[] table;

    public MyHashMap() {

    }





    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket)
                    if (entry.getValue().equals(value))
                        return true;
            }
        }

        return false;
    }

    @Override
    public java.util.Set<Entry<K, V>> entrySet() {
        java.util.Set<Entry<K, V>> set =
                new java.util.HashSet<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                set.addAll(bucket);
            }
        }
        return set;
    }

    @Override
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket)
                if (entry.getKey().equals(key))
                    return entry.getValue();
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public Set<K> keySet() {
        return null;
    }


    @Override
    public V put(K key, V value) {
        if (get(key) != null) {
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket)
                if (entry.getKey().equals(key)) {
                    V oldValue = entry.getValue();
                    entry.value = value;
                    return oldValue;
                }
        }


        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<Entry<K, V>>();
        }
        table[bucketIndex].add(new Entry<K, V>(key, value));
        size++;
        return value;
    }

    @Override
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());


        if (table[bucketIndex] != null) {
            LinkedList<BasicMap.Entry<K, V>> bucket = table[bucketIndex];
            for (BasicMap.Entry<K, V> entry : bucket)
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    size--;
                    break;
                }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<V> values() {
        return null;
    }


}
