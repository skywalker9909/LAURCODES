/* LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * LAB 5 - HASH TABLES
 * OCTOBER 22ND 2023
 */

public class UnitTest {
    public static void main(String[] args) {
        // Create an instance of the URHashTable (or its concrete subclass)
        URHashTable<String, Integer> hashTable = new URHashTable<>(); // Replace with your concrete class

        System.out.println("This is a unit test file for the Hash Table I designed!");

        try {
            // Test put and get methods
            hashTable.put("Alice", 25);
            hashTable.put("Bob", 30);
            hashTable.put("Charlie", 35);

            System.out.println("Alice's age: " + hashTable.get("Alice")); // Should print 25
            System.out.println("Bob's age: " + hashTable.get("Bob"));       // Should print 30

            // Test size and isEmpty methods
            System.out.println("Size: " + hashTable.size());         // Should print 3
            System.out.println("Is empty: " + hashTable.isEmpty());  // Should print false

            // Test delete method
            hashTable.delete("Alice");
            System.out.println("Alice's age (after deletion): " + hashTable.get("Alice")); // Should print null

            // Test contains method
            System.out.println("Contains Alice: " + hashTable.contains("Alice")); // Should print false
            System.out.println("Contains Bob: " + hashTable.contains("Bob"));       // Should print true
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        
        }

        try {
            // Test putting a null key
            hashTable.put(null, 40); // This should throw an IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }
}
