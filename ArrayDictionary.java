package homework;

import java.util.Arrays;

public class ArrayDictionary<K, V> implements Dictionary<K, V> {

    private Object[] keys;
    private Object[] values;
    private int size;

    public ArrayDictionary() {
        keys = new Object[10];
        values = new Object[10];
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals((K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        if (value == null) {
            remove(key);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, size * 2);
            values = Arrays.copyOf(values, size * 2);
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public void remove(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                System.arraycopy(keys, i + 1, keys, i, size - i - 1);
                System.arraycopy(values, i + 1, values, i, size - i - 1);
                size--;
                return;
            }
        }
    }
}
