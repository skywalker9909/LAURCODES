/* LAUREL TAY RAEANNE
 * LTAY3@U.ROCHESTER.EDU
 * CSC172 LAB 6
 * OCTOBER 29TH
 */

public class BSTUnitTest {
    public static void main(String[] args) {
        ConcreteBST<Integer, String> bst = new ConcreteBST<>();

        // Test isEmpty
        System.out.println("Is BST empty? " + bst.isEmpty());

        // Test put and get
        bst.put(5, "five");
        bst.put(11, "eleven");
        bst.put(3, "three");
        bst.put(28, "twenty eight");
        bst.put(7, "seven");
        bst.put(12, "twelve");
        bst.put(13, "thirteen");
        bst.put(14, "fourteen");
        System.out.println("Value at key 5: " + bst.get(5));

        System.out.println("Level Order Traversal:");
        for (Integer key : bst.levelOrder()) {
            System.out.println(key);
        }

        // Test size
        System.out.println("Size of BST: " + bst.size());

        // Test contains
        System.out.println("Does BST contain key 3? " + bst.contains(3));

        // Test deleteMin
        bst.deleteMin();
        System.out.println("Size of BST after deleting minimum: " + bst.size());

        // Test deleteMax
        bst.deleteMax();
        System.out.println("Size of BST after deleting maximum: " + bst.size());

        // Test delete
        bst.delete(5);
        System.out.println("Size of BST after deleting key 5: " + bst.size());

        // Test height
        System.out.println("Height of BST: " + bst.height());

        // Test level order traversal
        System.out.println("Level Order Traversal:");
        for (Integer x : bst.levelOrder()) {
            System.out.println(x + " ");
        }

        // Test in order traversal
        System.out.println("In-Order Traversal:");
        for (Integer key : bst.keys()) {
            System.out.print(key + "\n");
        }
    }
}
