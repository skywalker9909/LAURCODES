/*
 * LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC 172 PROJECT 3
 */

import java.util.ArrayList;

// Define the Heap class for a binary heap data structure
public class Heap {

	public Node[] myheap; // Array to store the heap elements
	int lastone = 0; // Index of the last element in the heap

	// Constructor for initializing the heap
	public Heap() {
		myheap = new Node[10];
		myheap[0] = null; // The first element is not used

	}

	// Method to calculate the index of the parent of a given index
	public int fp(int index) {

		return (int) ((index) / 2);

	}

	// Method to swap two elements in the heap
	public void swap(int a, int b) {

		Node tempt1 = myheap[a];
		Node tempt2 = myheap[b];
		int i1 = tempt1.heapindex;
		int i2 = tempt2.heapindex;
		tempt1.heapindex = i2;
		tempt2.heapindex = i1;
		myheap[a] = tempt2;

		myheap[b] = tempt1;

	}

	// Method to perform a bubble-up operation on the heap
	public void bubbleup(int index) {
		if (index != 1) {
			int pi = fp(index);

			Node parent = myheap[pi];
			Node Child = myheap[index];
			if (Child.compareTo(parent) < 0) {
				swap(pi, index);
				if (pi != 1) {
					bubbleup(pi);
				}
			}
		}

	}

	// Method to perform a bubble-down operation on the heap
	public void bubbledown(int index) {

		int child1 = 2 * index;
		int child2 = 2 * index + 1;
		if (child1 > lastone) {

		} else if (child2 > lastone) {

			if (myheap[child1].compareTo(myheap[index]) < 0) {

				swap(child1, index);

				bubbledown(child1);
			}

		}

		else {

			Node a = myheap[child1];
			Node b = myheap[child2];
			Node c = myheap[index];
			Double ad = a.dist;
			Double bd = b.dist;
			Double pd = c.dist;
			if (pd < ad && pd < bd) {

			} else if (ad < bd) {

				swap(child1, index);
				bubbledown(child1);
			}

			else {

				swap(child2, index);
				bubbledown(child2);
			}
		}
	}

	// Method to insert an element into the heap
	public void insert(Node item) {
		// TODO Auto-generated method stub
		try {
			lastone = lastone + 1;
			myheap[lastone] = item;
			item.heapindex = lastone;
			bubbleup(lastone);
		} catch (ArrayIndexOutOfBoundsException e) {

			Node[] newheap = new Node[myheap.length * 2];
			for (int i = 0; i < myheap.length; i++) {

				newheap[i] = myheap[i];

			}
			lastone -= 1;
			myheap = newheap;
			insert(item);

		}

	}

	 // Method to check if the heap is empty
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (myheap[1] == null) {

			return true;
		}

		return false;
	}

	// Method to get the size (number of elements) of the heap
	public int size() {
		int size = 0;
		for (int i = 0; i < myheap.length; i++) {

			if (myheap[i] != null) {
				size += 1;
			}
		}
		return size;
	}

	// Method to delete the minimum element from the heap (root) and maintain the heap property
	public Node deleteMin() {
		// TODO Auto-generated method stub
		Node tempt = myheap[1];
		myheap[lastone].heapindex = 0;
		swap(1, lastone);
		myheap[lastone] = null;
		lastone -= 1;

		bubbledown(1);

		return tempt;
	}

	// Method to decrease the key (distance) of a node in the heap
	public void decreaseKey(Node a, double value) {
		if (value > a.dist) {
			System.out.println("error! ");
		} else {

			a.dist = value;
			bubbleup(a.heapindex);
		}
	}

	// Method to check if a node is in the heap
	public boolean contain(Node x) {

		if (x.heapindex == 0) {
			return false;
		} else
			return true;

	}

}
			