// LAUREL TAY RAEANNE
// LTAY3@U.ROCHESTER.EDU
// CSC172 LAB 7
// NOVEMBER 4TH 2023

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class UnitTest {
    public static void main(String[] args) {
    
        MyHeap<Integer> heap = new MyHeap<>();
        System.out.println();

        // Testing size() and isEmpty()
        System.out.println("ISEMPTY & SIZE TEST:");
        System.out.println("Is the heap empty? " + heap.isEmpty());
        System.out.println("Heap size: " + heap.size());
        System.out.println();

        //Testing insert()
        System.out.println("INSERTION TEST:");
        System.out.println("Now after inserting 5 integers into the heap...");

        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        System.out.println("Is the heap empty? " + heap.isEmpty());

        System.out.print("Current heap: ");
        heap.printHeap();

        //Testing deleteMin()
        System.out.println();
        System.out.println("DELETEMIN TEST:");
        System.out.println("After deleting min...");
        heap.deleteMin();
        System.out.print("Heap now becomes ");
        heap.printHeap();
        System.out.println("Heap size: " + heap.size());

        //Testing expand()
        System.out.println();
        for (int i = 1; i <= 30; i++) {
            heap.insert(i);
        }
        System.out.println("EXPANSION TEST:");
        System.out.println("expanding heap...");
        System.out.println("Heap size after expansion: " + heap.size());
        System.out.println("Heap after expansion: ");
        heap.printHeap();

        // Testing heapify with random array
        System.out.println();
        System.out.println("TESTING RANDOM ARRAY TO HEAP:");
        Integer[] randomArray = generateRandomArray(10);
        System.out.println("Random Array: " + Arrays.toString(randomArray));

        MyHeap<Integer> heapFromRandomArray = new MyHeap<>(randomArray);
        System.out.print("Heap from Random Array: ");
        heapFromRandomArray.printHeap();
        System.out.println();

    }

    private static Integer[] generateRandomArray(int size) {
        Random rand = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }
}
