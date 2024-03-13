/*
 * Laurel Tay Raeanne
 * Lab 4
 * ltay3@u.rochester.edu
 * 10/1/23
 * 
 */
 

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


class URArrayListIterator<E> implements Iterator<E> {
    private int currentIndex = 0;
    private URArrayList<E> arrayList;

    public URArrayListIterator(URArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < arrayList.size();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arrayList.get(currentIndex++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}


public class URArrayList<E> implements URList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;

    public URArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public URArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        data = (E[]) new Object[initialCapacity];
        size = 0;
    }

    // Ensure the capacity of the internal array
    private void ensureCapacity(int minCapacity) {
        int currentCapacity = data.length;
        if (minCapacity > currentCapacity) {
            int newCapacity = currentCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    // Return the current capacity of the internal array
    public int getCapacity() {
        return data.length;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        data[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Object[] elements = c.toArray();
        int numNew = elements.length;
        ensureCapacity(size + numNew);
        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(data, index, data, index + numNew, numMoved);
        }
        System.arraycopy(elements, 0, data, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof URArrayList)) {
            return false;
        }
        URArrayList<?> otherList = (URArrayList<?>) o;

        if (size != otherList.size()) {
            return false;
        }

        Iterator<E> thisIterator = iterator();
        Iterator<?> otherIterator = otherList.iterator();

        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            E thisElement = thisIterator.next();
            Object otherElement = otherIterator.next();

            if (!(thisElement == null ? otherElement == null : thisElement.equals(otherElement))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return data[index];
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
    return new URArrayListIterator<>(this); // Pass 'this' to provide the current URArrayList instance
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        E oldValue = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null; // Clear to let GC do its work
        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (data[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(data[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null; // Clear to let GC do its work
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Iterator<?> iterator = iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (c.contains(element)) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        E oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public URList<E> subList(int fromIndex, int toIndex) {
    if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
        throw new IndexOutOfBoundsException("Index is out of bounds");
    }
    
    URArrayList<E> subList = new URArrayList<>();
    for (int i = fromIndex; i < toIndex; i++) {
        subList.add(data[i]);
    }
    
    return subList;
}


    @Override
    public Object[] toArray() {
        Object[] array = new Object[size]; // Create an array of Object type
        for (int i = 0; i < size; i++) {
            array[i] = data[i]; // Fill the array with elements from the 'data' array
        }
     return array;
    }   
    
}



       
