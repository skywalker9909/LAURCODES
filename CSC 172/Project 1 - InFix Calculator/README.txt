CS PROJECT 1

LAUREL RAEANNE TAY
LTAY3@U.ROCHESTER.EDU
OCTOBER 18TH 2023

Overview:
The Infix Calculator is a Java program that can evaluate mathematical expressions in infix notation. It supports various operators, including basic arithmetic, logical, and relational operators. The program reads expressions from an input file, converts them to postfix notation, evaluates the expressions, and writes the results to an output file. It handles operator precedence and parentheses correctly.

Files Included:
- InfixCalc.java: This class is responsible for converting infix expressions to postfix notation and evaluating them. It contains methods to handle various operators and parentheses. The class uses custom stack and queue data structures for processing expressions.

- URCalculator.java: This class is the main program that reads expressions from an input file, processes each line, and writes the result to an output file. It utilizes the InfixCalc class to evaluate the expressions.

Custom Data Structures:
To support the functionality of the InfixCalc class, I have included two packages:

- Queue Folder
This package contains the following files, which are imported and used for the output queue in the project:
1. DoublyLinkedList.java
2. TheDoubleNode.java
3. TheDoublyLinkedList.java
4. TheQueue.java
5. Queue.java

- Stack Folder
This package contains the following files, which are imported and used for the operator stack in the project:
1. TheStack.java
2. TheList.java
3. TheNode.java
4. SimpleLinkedList.java
5. Stack.java

Usage:
To use the program, run the URCalculator class with the following command-line arguments:
"java URCalculator input_file output_file"
input_file: The name of the plain text file containing the infix expressions to be evaluated.
output_file: The name of the plain text file where the results will be written.

Notable Features:
- Expression Conversion: The program converts infix expressions to postfix notation, taking into account operator precedence and parentheses. It handles various operators such as +, -, *, /, %, <, >, =, &, |, !, ^.

Error Handling: 
- The program provides error handling for cases such as division by zero, ensuring that it does not crash when encountering invalid expressions.
- Lines 186-188

Challenges:
- The implementation of the InfixCalc class required careful management of operator precedence and correct handling of parentheses in expressions. It was important to ensure that the order of operations was maintained.

- Handling edge cases, such as division by zero, required special checks and error messages to provide informative output.

Extra Credit:
- I included the ability to handle modulus and exponent as well as handling the error when there is division by zero in the equation
