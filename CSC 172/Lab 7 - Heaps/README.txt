// LAUREL TAY RAEANNE
// LTAY3@U.ROCHESTER.EDU
// CSC172 LAB 7
// NOVEMBER 4TH 2023

LAB SYNOPSIS:
The core tasks involve implementing the UR_Heap interface, developing a class that manages the heap with methods for insertion, deletion, and array expansion, and introducing a heapify operation to efficiently convert an array into a heap.

FILES I SUBMITTED:
1. MyHeap.java - file with all the methods
2. URHeap.java - interface code
3. UnitTest.java - unit test file to test methods, has the main method

HOW TO USE UNIT TEST:
Just run the unit test file, the output clearly states where and how each method is tested. 

ERROR HANDLING:
1. In the insert method, check if the size of the heap has reached its capacity and then expand the array if necessary. This is a proactive measure to avoid array overflow.
2. In the deleteMin method, check if the heap is empty before attempting to delete the minimum element. If the heap is empty, a NoSuchElementException is thrown to indicate that an error occurred.
3. Ensure that the indices used for accessing the heap array are within bounds, particularly in the bubbleUp and bubbleDown methods, by comparing them with the size of the heap.