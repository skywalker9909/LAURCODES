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

 interface Iterable<E> {

    boolean add(E e);
    void add(int index, E element);
    boolean    addAll(Collection<? extends E> c);
    boolean addAll(int index, Collection<? extends E> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<?> c);
    boolean equals(Object o);
    E get(int index);
    int indexOf(Object o);
    boolean isEmpty();
    Iterator<E> iterator();
    E remove(int index);
    boolean remove(Object o);
    boolean removeAll(Collection<?> c);
    E set(int index, E element);
    int size();
    Iterable<E> subList(int fromIndex, int toIndex);
    Object[] toArray();

 }
 
 
public class URLinkedList<E> implements URList<E> {
     private URNode<E> head;
     private URNode<E> tail;
     private int size;
 
     public URLinkedList() {
         head = null;
         tail = null;
         size = 0;
     }

     // Returns an iterator over the elements in this list in proper sequence.
     public Iterator<E> iterator() {
        return new LinkedListIterator();
     }
 
     // Appends the specified element to the end of this list
     @Override
     public boolean add(E e) {
         // Create a new node with the element
         URNode<E> newNode = new URNode<>(e, tail, null);
 
         // If the list is empty, set the head to the new node
         if (isEmpty()) {
             head = newNode;
         } else {
             // Otherwise, update the next reference of the previous tail node
             tail.setNext(newNode);
         }
 
         // Update the tail to the new node and increment the size
         tail = newNode;
         size++;
         return true;
     }
    // Inserts the specified element at the specified position in this list
     @Override
     public void add(int index, E element) {
         // Check if the index is out of bounds
         if (index < 0 || index > size) {
             throw new IndexOutOfBoundsException("Index is out of bounds");
         }
 
         if (index == 0) {
             // Adding at the beginning is equivalent to addFirst
             addFirst(element);
         } else if (index == size) {
             // Adding at the end is equivalent to addLast
             addLast(element);
         } else {
             // Create a new node with the element
             URNode<E> newNode = new URNode<>(element, null, null);
             URNode<E> current = getNodeAtIndex(index);
 
             // Update references to insert the new node
             newNode.setPrev(current.prev());
             newNode.setNext(current);
             current.prev().setNext(newNode);
             current.setPrev(newNode);
 
             // Increment the size
             size++;
         }
     }
 
     // Appends all of the elements in the specified collection to the end of this list,
    // in the order that they are returned by the specified collection's iterator
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
     // Inserts all of the elements in the specified collection into this list
    // at the specified position
     @Override
     public boolean addAll(int index, Collection<? extends E> c) {
         if (index < 0 || index > size) {
             throw new IndexOutOfBoundsException("Index is out of bounds");
         }
 
         E[] elements = (E[]) c.toArray();
 
         for (int i = 0; i < elements.length; i++) {
             add(index + i, elements[i]);
         }
         return elements.length > 0;
     }

     // Removes all of the elements from this list
     @Override
     public void clear() {
         head = null;
         tail = null;
         size = 0;
     }
     
     // Returns true if this list contains the specified element.
     @Override
     public boolean contains(Object o) {
         for (URNode<E> current = head; current != null; current = current.next()) {
             if (o == null ? current.element() == null : o.equals(current.element())) {
                 return true;
             }
         }
         return false;
     }
 
     // Returns true if this list contains all of the elements of the specified collection
     @Override
     public boolean containsAll(Collection<?> c) {
         for (Object element : c) {
             if (!contains(element)) {
                 return false;
             }
         }
         return true;
     }
 
    // Compares the specified object with this list for equality.
    // Returns true if both contain the same elements. Ignore capacity
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof URLinkedList)) {
            return false;
        }
        URLinkedList<?> otherList = (URLinkedList<?>) o;

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
    // Returns the element at the specified position in this list.
     @Override
     public E get(int index) {
         if (index < 0 || index >= size) {
             throw new IndexOutOfBoundsException("Index is out of bounds");
         }
         return getNodeAtIndex(index).element();
     }
 
     // Returns the index of the first occurrence of the specified element in this list,
     // or -1 if this list does not contain the element.
     @Override
     public int indexOf(Object o) {
         int index = 0;
         for (URNode<E> current = head; current != null; current = current.next()) {
             if (o == null ? current.element() == null : o.equals(current.element())) {
                 return index;
             }
             index++;
         }
         return -1;
     }

     // Returns true if this list contains no elements.
     @Override
     public boolean isEmpty() {
         return size == 0;
     }

     // Removes the element at the specified position in this list
     @Override
    public E remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        URNode<E> nodeToRemove = getNodeAtIndex(index);
        if (nodeToRemove == head) {
            // Removing the head is equivalent to removeFirst
            return removeFirst();
        } else if (nodeToRemove == tail) {
            // Removing the tail is equivalent to removeLast
            return removeLast();
        } else {
            // Update references to remove the node
            nodeToRemove.prev().setNext(nodeToRemove.next());
            nodeToRemove.next().setPrev(nodeToRemove.prev());

            // Decrement the size
            size--;

            return nodeToRemove.element();
        }
    }

    // Removes the first occurrence of the specified element from this list,
     @Override
     public boolean remove(Object o) {
         for (URNode<E> current = head; current != null; current = current.next()) {
             if (o == null ? current.element() == null : o.equals(current.element())) {
                 if (current == head) {
                     removeFirst();
                 } else if (current == tail) {
                     removeLast();
                 } else {
                     current.prev().setNext(current.next());
                     current.next().setPrev(current.prev());
                     size--;
                 }
                 return true;
             }
         }
         return false;
     }

     // Removes from this list all of its elements that are contained // in the specified collection
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

    // Replaces the element at the specified position in this list
    // with the specified element
     @Override
     public E set(int index, E element) {
         if (index < 0 || index >= size) {
             throw new IndexOutOfBoundsException("Index is out of bounds");
         }
         URNode<E> nodeToReplace = getNodeAtIndex(index);
         E oldValue = nodeToReplace.element();
         nodeToReplace.setElement(element);
         return oldValue;
     }
 
    // Returns the number of elements in this list.
     @Override
     public int size() {
         return size;
     }
 
     // Returns a view of the portion of this list
    // between the specified fromIndex, inclusive, and toIndex, exclusive.
     @Override
     public URList<E> subList(int fromIndex, int toIndex) {
         if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
             throw new IndexOutOfBoundsException("Index is out of bounds");
         }
 
         URLinkedList<E> subList = new URLinkedList<>();
         URNode<E> current = getNodeAtIndex(fromIndex);
 
         for (int i = fromIndex; i < toIndex; i++) {
             subList.addLast(current.element());
             current = current.next();
         }
 
         return subList;
     }
 
    // Returns an array containing all of the elements in this list // in proper sequence (from first to the last element).
     @Override
     public Object[] toArray() {
         Object[] array = new Object[size];
         int index = 0;
         for (Object element : array) {
             array[index++] = element;
         }
         return array;
     }
 
     private URNode<E> getNodeAtIndex(int index) {
         int currentIndex = 0;
         URNode<E> current = head;
         while (currentIndex < index) {
             current = current.next();
             currentIndex++;
         }
         return current;
     }
    
     // Inserts the specified element at the beginning of this list.
     public void addFirst(E e) {
         URNode<E> newNode = new URNode<>(e, null, head);
         if (isEmpty()) {
             tail = newNode;
         } else {
             head.setPrev(newNode);
         }
         head = newNode;
         size++;
     }
 
     // Appends the specified element to the end of this list.
     public void addLast(E e) {
         add(e);
     }
 
     // Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
     public E peekFirst() {
         if (isEmpty()) {
             return null;
         }
         return head.element();
     }
 
     // Retrieves, but does not remove, the last element of this list, or returns null if this list is empty
     public E peekLast() {
         if (isEmpty()) {
             return null;
         }
         return tail.element();
     }
 
     // Retrieves and removes the first element of this list, or returns null if this list is empty.
     public E pollFirst() {
         if (isEmpty()) {
             return null;
         }
         E element = head.element();
         removeFirst();
         return element;
     }
 
     // Retrieves and removes the last element of this list, or returns null if this list is empty.
     public E pollLast() {
         if (isEmpty()) {
             return null;
         }
         E element = tail.element();
         removeLast();
         return element;
     }
 
     public E removeFirst() {
         if (isEmpty()) {
             throw new NoSuchElementException("List is empty");
         }
         E element = head.element();
         head = head.next();
         if (head != null) {
             head.setPrev(null);
         } else {
             tail = null;
         }
         size--;
         return element;
     }
 
     public E removeLast() {
         if (isEmpty()) {
             throw new NoSuchElementException("List is empty");
         }
         E element = tail.element();
         tail = tail.prev();
         if (tail != null) {
             tail.setNext(null);
         } else {
             head = null;
         }
         size--;
         return element;
    }

    
    private class LinkedListIterator implements Iterator<E> {
        private URNode<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.element();
            current = current.next();
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    }

    