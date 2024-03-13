Name: Laurel Tay
BB: LTAY3@U.ROCHESTER.EDU
Assignment Resubmission: Homework 4 Airplane

The following changes were made to my original code:

1. Renamed some of the class variables for better readability.
2. Added a private prof variable to the Airplane class to store the calculated profit from the estimateProf method.
3. Changed the return type of the estimateProf method from void to double.
4. Replaced the for loop in the main method for processing the airplane information and assigning it to the fleet array with a for-each loop.
5. Replaced the outer for loop in the main method for processing the cargo, distance, and payment information with a while loop that checks if the input is "quit" to exit the loop.
6. Changed the condition in the inner for loop in the main method for calculating the profit from profit > bestProfit to profit >= 0 && profit > bestProfit to handle the case where the profit is equal to 0.