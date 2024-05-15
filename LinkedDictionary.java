package homework;

public class LinkedDictionary<K, V> implements Dictionary<K, V> {

    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node anchor = null;

    @Override
    public V get(K key) {
        Node n = anchor;
        while (n != null && !n.key.equals(key)) {
            n = n.next;
        }
        return (n != null) ? n.value : null;
    }

    @Override
    public boolean isEmpty() {
        return anchor == null;
    }

    @Override
    public void put(K key, V value) {
        if (value == null) {
            remove(key);
            return;
        }
        Node n = anchor;
        while (n != null && !n.key.equals(key)) {
            n = n.next;
        }
        if (n == null) {
            anchor = new Node(key, value, anchor);
        } else {
            n.value = value;
        }
    }

    @Override
    public void remove(K key) {
        if (anchor == null) return;  // Empty dictionary
        if (anchor.key.equals(key)) {
            anchor = anchor.next;
            return;
        }
        assert anchor != null && !anchor.key.equals(key);
        Node prev = anchor;
        Node n = prev.next;
        while (n != null && !n.key.equals(key)) {
            prev = n;
            n = n.next;
        }
        if (n == null) return;  // Not found
        assert prev != null && prev.next == n && n != null && n.key.equals(key);
        prev.next = n.next;
    }
}
