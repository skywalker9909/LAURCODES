   
CONTACT INFORMATION
NAME: LAUREL TAY RAEANNE
EMAIL: LTAY3@U.ROCHESTER.EDU

- BRIEF EXPLANATION OF LAB:

Source files: URLinkedList.java, URArrayList.java, UnitTest,java

The objective of this lab is to familiarize students with the implementation of custom data structures, specifically linked lists, in Java. The main aim is to have students create a working URLinkedList class that adheres to the provided URList interface, while also handling corner cases and error scenarios gracefully. Through this exercise, students gain hands-on experience in designing and implementing data structures, practicing proper commenting, and ensuring their code is robust and functional. The lab also encourages students to write unit tests to validate the correctness of their implementations, promoting a deeper understanding of how data structures work.

- CORNER CASES & ERROR HANDLING:

Index Out of Bounds Handling: I check for index out of bounds errors in methods like add(int index, E element), get(int index), remove(int index), and subList(int fromIndex, int toIndex). When an invalid index is provided, an IndexOutOfBoundsException is thrown

Empty List Handling: I handle the case of an empty list appropriately in methods like add(E e), addFirst(E e), peekFirst(), pollFirst(), removeFirst(), addLast(E e), peekLast(), pollLast(), and removeLast(). In these methods, I check if the list is empty and take the necessary actions, such as updating the head and tail references.

Element Existence Check: In methods like contains(Object o), containsAll(Collection<?> c), and remove(Object o), I check for the existence of elements before performing operations on them.

Iterator Support: I provide an iterator in the form of the LinkedListIterator inner class, which is essential for iterating over the elements in the list. I also throw an UnsupportedOperationException in the remove() method of the iterator to indicate that removal through the iterator is not supported.

Size Maintenance: I consistently update the size member variable when elements are added or removed, ensuring that it reflects the actual size of the list.


- UNIT TEST FILE

This unit test file, named UnitTest, tests two different implementations of the URList interface: URLinkedList and URArrayList. Here's a brief explanation of how this unit test works:

Testing URLinkedList:

A URLinkedList instance is created.
Elements (integers) are added to the list using the add method, and the size is checked to ensure that elements are added correctly.
The get and contains methods are used to retrieve an element by index and check if an element is present in the list.
A collection of integers is created, and the addAll method is used to add the collection to the URLinkedList. Again, the size is checked.
The indexOf method is used to find the index of an element in the list, and a sublist is created using the subList method.
An element is removed using the remove method, and the size is checked again.
The elements in the list are printed using an iterator.
Finally, the clear method is used to empty the list, and the isEmpty method is used to check if the list is empty.
Testing URArrayList:

A URArrayList instance is created.
Elements (strings) are added to the list using the add method, and the size is checked.
The get and contains methods are used to retrieve an element by index and check if an element is present.
A collection of strings is created, and the addAll method is used to add the collection to the URArrayList. The size is checked.
The indexOf method is used to find the index of an element, and a sublist is created.
An element is removed using the remove method, and the size is checked.
The elements in the list are printed using an iterator.
Finally, the clear method is used to empty the list, and the isEmpty method is used to check if the list is empty.