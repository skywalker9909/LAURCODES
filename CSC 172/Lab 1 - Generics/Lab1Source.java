import java.util.Arrays;
import java.util.function.Function;

class Lab1Source {
    public static void main(String[] args) {
        Integer[] intArry = {1,2,3,4,5};
        Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H','E', 'L', 'L', 'O'};
        String[] strArray = {"once", "upon", "a", "time"};
        
        printArray(intArry);
        printArray(doubArry);
        printArray(charArray);
        printArray(strArray);

        System.out.println("max Integer is: " + getMax(intArry));
        System.out.println("max Double is: " + getMax(doubArry));
        System.out.println("max Character is: " + getMax(charArray));
        System.out.println("max String is: " + getMax(strArray));
    }

//QUESTION 1
public static void printArray(Object[] array) {
    System.out.print("[ ");
    for (int i = 0; i < array.length; i++) {
        if (i > 0) {
            System.out.print(", ");
        }
        System.out.print(array[i]);
    } 
   System.out.println(" ]");
}

//QUESTION 2
    public static void printArray(Integer[] intArray) {
        System.out.print("[ ");
        for (int i = 0; i < intArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(intArray[i]);
        } 
       System.out.println(" ]");
    }

    public static void printArray(Double[] doubArray) {
        System.out.print("[ ");
        for (int i = 0; i < doubArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(doubArray[i]);
        } 
       System.out.println(" ]");
    }

    public static void printArray(Character[] charArray) {
        System.out.print("[ ");
        for (int i = 0; i < charArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(charArray[i]);
        } 
       System.out.println(" ]");
    }

    public static void printArray(String[] strArray) {
        System.out.print("[ ");
        for (int i = 0; i < strArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(strArray[i]);
        } 
       System.out.println(" ]");
    }


//QUESTION 3
    public static <T> void printArray(T[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        } 
       System.out.println(" ]");
    }

//QUESTION 4
/*Compilation errors: 
Note: Laurel.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
*/

    public static Comparable getMax(Comparable [] anArray) {
        if (anArray == null || anArray.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        Comparable max = anArray[0];
        for (int i = 1; i < anArray.length; i++) {
            if (anArray[i].compareTo(max) > 0) { //use compareTo() method which can be used to compare Objects as array
                max = anArray[i];                //may not store just numbers so cannot use "anArray[i] > anArray[i + 1]
            }
        }

        return max;
    }

//QUESTION 5
    public static <T extends Comparable<T>> T getMax(T[] anArray) {
        if (anArray == null || anArray.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        T max = anArray[0];
        for (int i = 1; i < anArray.length; i++) {
            if (anArray[i].compareTo(max) > 0) { //use compareTo() method which can be used to compare Objects as array
                max = anArray[i];                //may not store just numbers so cannot use "anArray[i] > anArray[i + 1]
            }
        }

        return max;
    }

}

//QUESTION 6

    public static void main(String[] args) {
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        findMax<Character> findMaxFunction = arr -> {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("Input array is empty or null.");
            }

            Character max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }

            return max;
        };

        Character maxChar = findMaxFunction.apply(charArray);
        System.out.println("Maximum Character: " + maxChar);
    }

    @FunctionalInterface
    interface findMax<T> {
        T apply(T[] arr);
    }
}

