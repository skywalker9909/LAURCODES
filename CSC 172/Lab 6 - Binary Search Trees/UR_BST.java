/* LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC172 LAB 6
 * OCTOBER 29TH
 */

import java.util.NoSuchElementException;
import java.lang.Iterable;

abstract public class UR_BST<Key extends Comparable<Key>, Value> {

    abstract public boolean isEmpty();

    abstract public int size();

    abstract public boolean contains(Key key);

    abstract public Value get(Key key);

    abstract public void put(Key key, Value val);

    abstract public void deleteMin();

    abstract public void deleteMax();

    abstract public void delete(Key key);

    abstract public Iterable<Key> keys();

    abstract public int height();

    abstract public Iterable<Key> levelOrder();
}
