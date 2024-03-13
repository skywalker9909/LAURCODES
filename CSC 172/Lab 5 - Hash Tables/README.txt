LAUREL RAEANNE TAY
CSC 172 LAB 5 HASH TABLES
LTAY3@U.ROCHESTED.EDU
22 OCTOBER 2023

LAB SYNOPSIS:
This lab assignment focuses on the implementation of a Hash Table data structure. The code is written in Java and is designed to handle key-value pairs efficiently, providing methods to insert, retrieve, and delete entries. Additionally, the code implements collision handling strategies for a more robust Hash Table structure.


CONTENTS:
1. URHashTable.java - The main Java class implementing the Hash Table.
2. UnitTest.java - A Java unit test file for testing the functionality of the Hash Table.


RUNNING UNIT TEST:
1. Compile the source files using a Java compiler (e.g., javac URHashTable.java UnitTest.java).
2. Run the unit test using the Java Virtual Machine (e.g., java UnitTest).
3. The unit test will execute various test cases, including insertions, retrievals, deletions, and error scenarios. The test results will be printed to the console.

ERROR HANDLING:

1. Null Key Handling: To prevent inserting or retrieving entries with null keys, the code throws an IllegalArgumentException when attempting to insert a key-value pair with a null key.

2. Key Not Found: When attempting to delete a key that is not present in the Hash Table, the code ensures graceful handling by not performing any actions, preventing unexpected errors.

3. Collision Handling: The code implements a collision handling mechanism, tracking and counting collisions to ensure data integrity.

