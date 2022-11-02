package HW9;

import java.util.Stack;

public class MyHashMap <T>{
    class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        
    }
    static final int DEF_CAPACITY = 16;
    transient T[] table;

    /**
     * The number of key-value mappings contained in this map.
     */
    transient int size;
}
