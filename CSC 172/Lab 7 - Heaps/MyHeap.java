// LAUREL TAY RAEANNE
// LTAY3@U.ROCHESTER.EDU
// CSC172 LAB 7
// NOVEMBER 4TH 2023

import java.util.NoSuchElementException;

public class MyHeap<T extends Comparable<T>> implements UR_Heap<T> {
    private T[] heapArray;
    private int size;
    private int capacity;

    public MyHeap(int initialCapacity) {
        this.heapArray = (T[]) new Comparable[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    public MyHeap() {
        this(10);
    }

    public MyHeap(T[] array) {
        this.heapArray = (T[]) new Comparable[array.length];
        this.size = array.length;

        for (int i = 0; i < array.length; i++) {
            heapArray[i] = array[i];
        }

        buildMaxHeap();
    }

    @Override
    public void insert(T item) {
        if (size >= capacity) {
            expand();
        }

        heapArray[size] = item;
        size++;
        bubbleUp(size - 1);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("The heap is empty.");
        }

        T min = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        size--;
        bubbleDown(0);

        return min;
    }

    // New constructor to build a heap from an array
    public MyHeap(T[] array, int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = array.length;
        this.heapArray = (T[]) new Comparable[capacity];

        for (int i = 0; i < array.length; i++) {
            heapArray[i] = array[i];
        }

        buildMaxHeap();
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (heapArray[index].compareTo(heapArray[parentIndex]) > 0) {
                T temp = heapArray[index];
                heapArray[index] = heapArray[parentIndex];
                heapArray[parentIndex] = temp;

                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < size && heapArray[leftChild].compareTo(heapArray[largest]) > 0) {
            largest = leftChild;
        }
        if (rightChild < size && heapArray[rightChild].compareTo(heapArray[largest]) > 0) {
            largest = rightChild;
        }

        if (largest != index) {
            T temp = heapArray[index];
            heapArray[index] = heapArray[largest];
            heapArray[largest] = temp;
            bubbleDown(largest);
        }
    }

    private void expand() {
        capacity *= 2;
        T[] newHeapArray = (T[]) new Comparable[capacity];
        System.arraycopy(heapArray, 0, newHeapArray, 0, size);
        heapArray = newHeapArray;
    }

    private void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    // New method to print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }

    // New method to perform heapify
    public void heapify() {
        buildMaxHeap();
    }
}
