
/* LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * LAB 5 - HASH TABLES
 * OCTOBER 22ND 2023
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;


public class URHashTable<Key, Value> implements Iterable<Key> {

    private static final int INIT_CAPACITY = 5;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private int n; // number of key-value pairs in the table
    private int m; // size of the hash table
    private Key[] keys;
    private Value[] vals;
    int inserts, collisions;

    public int getInserts() {
        return inserts;
    }

    public int getCollisions() {
        return collisions;
    }

    // Constructors
    public URHashTable() {
        inserts = 0;
        collisions = 0;
    }

    public URHashTable(int cap) {
        m = cap;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
        inserts = 0;
        collisions = 0;
    }

    // Public methods

    //put method

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (n >= LOAD_FACTOR_THRESHOLD * m) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
            collisions++;
        }
        keys[i] = key;
        vals[i] = val;
        n++;
        inserts++;
    }

    //get

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null; // Key not found
    }


    // delete

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (!contains(key)) {
            return; // Key not in the table
        }

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;
        n--;

        // Rehash to ensure no gaps in the table
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key rehashKey = keys[i];
            Value rehashVal = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(rehashKey, rehashVal);
            i = (i + 1) % m;
        }

        // Resize if necessary to maintain the load factor
        if (n > 0 && n <= LOAD_FACTOR_THRESHOLD * m / 2) {
            resize(m / 2);
        }
    }

    // size

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.add(keys[i]);
            }
        }
        return queue;
    }

    // Private methods
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
        if (capacity < n) {
            throw new InternalError("Attempted to resize with insufficient capacity.");
        }

        URHashTable<Key, Value> temp = new URHashTable<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        this.keys = temp.keys;
        this.vals = temp.vals;
        this.m = temp.m;
    }

    // Implement Iterable interface
    public Iterator<Key> iterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<Key> {
        private int current = 0;

        public boolean hasNext() {
            return current < m;
        }

        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while (keys[current] == null) {
                current++;
            }
            return keys[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}
