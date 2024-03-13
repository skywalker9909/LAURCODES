/* LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC172 LAB 6
 * OCTOBER 29TH
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;


public class ConcreteBST<Key extends Comparable<Key>, Value> extends UR_BST<Key, Value> {
    private UR_Node root; // root of BST

    private class UR_Node {
        private Key key; // sorted by key
        private Value val; // associated data
        private UR_Node left, right; // left and right subtrees
        private int size; // number of nodes in subtree

        public UR_Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(UR_Node x) {
        if (x == null) return 0;
        return x.size;
    }

    @Override
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return get(key) != null;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(UR_Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        root = put(root, key, val);
    }

    private UR_Node put(UR_Node x, Key key, Value val) {
        if (x == null) return new UR_Node(key, val, 1);
        int xyz = key.compareTo(x.key);
        if (xyz < 0) x.left = put(x.left, key, val);
        else if (xyz > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table is empty");
        }
        root = deleteMin(root);
    }

    private UR_Node deleteMin(UR_Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table is empty");
        }
        root = deleteMax(root);
    }

    private UR_Node deleteMax(UR_Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        root = delete(root, key);
    }

    private UR_Node delete(UR_Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            UR_Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    private UR_Node min(UR_Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private void inOrderTraversal(UR_Node x, List<Key> keyList) {
        if (x != null) {
            inOrderTraversal(x.left, keyList);
            keyList.add(x.key);
            inOrderTraversal(x.right, keyList);
        }
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keyList = new ArrayList<>();
        inOrderTraversal(root, keyList);
        return keyList;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(UR_Node x) {
        if (x == null) return -1;
        int leftHeight = height(x.left);
        int rightHeight = height(x.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    @Override
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new LinkedList<>();
        Queue<UR_Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            UR_Node x = queue.poll();
            if (x != null) {
                keys.add(x.key);
                queue.add(x.left);
                queue.add(x.right);
            }
        }
        return keys;
    }
}
