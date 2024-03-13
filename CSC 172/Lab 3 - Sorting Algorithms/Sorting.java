/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;


public class Sorting {

public static void main(String[] args)  { 
    In in = new In(args[0]);
            int[] a = in.readAllInts();

    int[] b = new int[a.length];
    System.arraycopy(a, 0, b, 0, a.length);
    Arrays.sort(b);

    int[] c = new int[a.length];
    for (int i = 0; i < a.length; i++) {
        c[i] = b[a.length - 1 - i];
    }

    int[] d = new int[a.length];
    System.arraycopy(b, 0, d, 0, a.length);

    int numSwaps = (int) (0.1 * d.length);
    for (int i = 0; i < numSwaps; i++) {
        int index1 = StdRandom.uniform(a.length);
        int index2 = StdRandom.uniform(a.length);
        int temp = d[index1];
        d[index1] = d[index2];
        d[index2] = temp;
    }
    
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    String netID = "LTAY3"; 
    int algorithmNumber = Integer.parseInt(args[1]);
    
    printSortingResults(algorithmNumber, "a", a, timeStamp, netID, args[0],"a.txt");
    printSortingResults(algorithmNumber, "b", b, timeStamp, netID, args[0],"b.txt");
    printSortingResults(algorithmNumber, "c", c, timeStamp, netID, args[0],"c.txt");
    printSortingResults(algorithmNumber, "d", d, timeStamp, netID, args[0],"d.txt");

}

public static void bubbleSort(int[] arr) {
    int n = arr.length;
    boolean swapped;
    do {
        swapped = false;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                swapped = true;
            }
        }
        n--;
    } while (swapped);
}

public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        // Swap arr[i] and arr[minIndex]
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}

public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

public static void mergeSort(int[] arr) {
  int n = arr.length;
  if (n <= 1) {
      return;
  }

  int mid = n / 2;
  int[] left = new int[mid];
  int[] right = new int[n - mid];

  for (int i = 0; i < mid; i++) {
      left[i] = arr[i];
  }
  for (int i = mid; i < n; i++) {
      right[i - mid] = arr[i];
  }
  mergeSort(left);
  mergeSort(right);

  int i = 0, j = 0, k = 0;
  int n1 = left.length;
  int n2 = right.length;
  while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
          arr[k++] = left[i++];
      } else {
          arr[k++] = right[j++];
      }
  }

  while (i < n1) {
      arr[k++] = left[i++];
  }
  while (j < n2) {
      arr[k++] = right[j++];
  }
}
public static void quickSort(int[] arr, int low, int high) {
    while (low < high) {
        int pivotIndex = partition(arr, low, high);
        
        // Recursively sort the smaller subarray
        if (pivotIndex - low < high - pivotIndex) {
            quickSort(arr, low, pivotIndex - 1);
            low = pivotIndex + 1;
        } else {
            quickSort(arr, pivotIndex + 1, high);
            high = pivotIndex - 1;
        }
    }
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}

public static void printSortingResults(int algorithmNumber, String arrayName, int[] x, String timeStamp, String netID, String inputFileName, String outputFileName) {
    Stopwatch timer = new Stopwatch();
    String algorithmName = "";
    switch (algorithmNumber) {
        case 0:
            algorithmName = "Arrays.sort()";
            Arrays.sort(x);
            
            break;
        case 1:
            algorithmName = "Bubble Sort";
            bubbleSort(x);
            
            break;
        case 2:
            algorithmName = "Selection Sort";
            selectionSort(x);
            
            break;
        case 3:
            algorithmName = "Insertion Sort";
            insertionSort(x);
            
            break;
        case 4:
            algorithmName = "Mergesort";
            mergeSort(x);
            
            break;

        case 5:
          algorithmName = "Quicksort";
          quickSort(x, 0, x.length - 1);
          
          break;
        
        default:
            System.out.println("Invalid algorithm number.");
            return;
    }
    double time = timer.elapsedTimeMillis();

    System.out.printf("%s %s %.1f %s %s %s%n", algorithmName, arrayName, time, timeStamp, netID, inputFileName); 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int value : x) {
                writer.write(String.valueOf(value));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}}

