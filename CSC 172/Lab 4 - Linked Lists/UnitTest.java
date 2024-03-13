/*
 * Laurel Tay Raeanne
 * Lab 4
 * ltay3@u.rochester.edu
 * 10/1/23
 * 
 */

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class UnitTest {
    public static void main(String[] args) {
        testLinkedList();
        testArrayList();
    }

    private static void testLinkedList() {
        System.out.println("Testing URLinkedList:");
        URList<Integer> linkedList = new URLinkedList<>();
    
        // Test add and size
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("Size of linkedList: " + linkedList.size()); // Expected output: 3

    
        // Test get and contains
        System.out.println("Element at index 1: " + linkedList.get(1)); // Expected output: 2
        System.out.println("Contains 3? " + linkedList.contains(3)); // Expected output: true
    
        // Test addAll with a collection
        Collection<Integer> otherCollection = new ArrayList<>();
        otherCollection.add(4);
        otherCollection.add(5);
        linkedList.addAll(otherCollection);
        System.out.println("Size of linkedList after addAll: " + linkedList.size()); // Expected output: 5
    
        // Test indexOf and subList
        System.out.println("Index of 4 in linkedList: " + linkedList.indexOf(4)); // Expected output: 3
        URList<Integer> subList = linkedList.subList(1, 4);
        System.out.println("Sublist: " + subList); // Expected output: [2, 3, 4]
    
        // Test remove
        linkedList.remove(1);
        System.out.println("Size of linkedList after removal: " + linkedList.size()); // Expected output: 4
    
        // Iterate through the list and print elements
        System.out.print("Elements in linkedList: ");
        Iterator<Integer> linkedIterator = linkedList.iterator();
        while (linkedIterator.hasNext()) {
            Integer element = linkedIterator.next();
            System.out.print(element + " ");
        }

        // Test clear and isEmpty
        linkedList.clear();
        System.out.println("Is linkedList empty after clear? " + linkedList.isEmpty()); // Expected output: true

        System.out.println();
            
    }
    
    private static void testArrayList() {
        System.out.println();
        System.out.println("Testing URArrayList:");
        URList<String> arrayList = new URArrayList<>();
    
        // Test add and size
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println("Size of arrayList: " + arrayList.size()); // Expected output: 3
    
        // Test get and contains
        System.out.println("Element at index 1: " + arrayList.get(1)); // Expected output: "B"
        System.out.println("Contains 'C'? " + arrayList.contains("C")); // Expected output: true
    
        // Test addAll with a collection
        Collection<String> otherCollection = new ArrayList<>();
        otherCollection.add("D");
        otherCollection.add("E");
        arrayList.addAll(otherCollection);
        System.out.println("Size of arrayList after addAll: " + arrayList.size()); // Expected output: 5
    
        // Test indexOf and subList
        System.out.println("Index of 'D' in arrayList: " + arrayList.indexOf("D")); // Expected output: 3
        URList<String> subList = arrayList.subList(1, 4);
        System.out.println("Sublist: " + subList); // Expected output: ["B", "C", "D"]
    
        // Test remove
        arrayList.remove(1);
        System.out.println("Size of arrayList after removal: " + arrayList.size()); // Expected output: 4
    
       // Iterate through the list and print elements
        System.out.print("Elements in arrayList: ");
        Iterator<String> arrayIterator = arrayList.iterator();
        while (arrayIterator.hasNext()) {
            String element = arrayIterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Test clear and isEmpty
        arrayList.clear();
        System.out.println("Is arrayList empty after clear? " + arrayList.isEmpty()); // Expected output: true

    }
}
