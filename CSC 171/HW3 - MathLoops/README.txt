	•	Basics – 
	◦	Name: LAUREL TAY RAEANNE
	◦	School Email: LTAY3@U.ROCHESTER.EDU
	◦	Assignment Name: HOMEWORK 2, CALCULATOR
	◦	Date last modified: FEB 2ND 2023
	•	Algorithm description – 
	◦	The structure of my code is split into three sections: 
	▪	a method to check if it is a prime
	▪	a method to list the factors
	▪	a main method that call
	◦	The first method works like this:
	▪	It first checks if n is less than or equal to 1, which is not a prime number, so it returns false.
	▪	It then checks if n is equal to 2, which is the only even prime number, so it returns true.
	▪	It checks if n is even (i.e., divisible by 2). If n is even and not 2, then it cannot be a prime number, so it returns false.
	▪	Next, it sets a limit variable to the square root of n, since any factor of n that is greater than the square root of n must necessarily have a corresponding factor that is less than the square root of n.
	▪	The method then performs a loop starting from 3 (the first odd prime number) up to the limit, incrementing by 2 each time since we've already eliminated even numbers. It checks if n is divisible by the current value of i. If it is, then n is not a prime number, and the method returns false.
	▪	If the loop finishes without finding any factors of n, then n is a prime number, and the method returns true.
	◦	The second methods works like this:
	▪	It initialises a StringBuilder object called sb to store the prime factors as they are found.
	▪	It starts a loop that iterates over all integers from 2 up to n, inclusive. For each integer i, it checks if n is divisible by i without leaving a remainder (i.e., n % i == 0).
	▪	If n is divisible by i, then it means that i is a prime factor of n. The method appends i to the StringBuilder sb, adds a space after it, and divides n by i.
	▪	The method continues the loop, checking if n is divisible by i again, and repeats the division process until n is no longer divisible by i.
	▪	The loop continues with the next integer i until it reaches n. At this point, all of the prime factors of n have been found and added to the StringBuilder sb.
	▪	The method returns the string representation of the StringBuilder sb, with any leading or trailing white space removed.
	◦	The main method works to allow the program to function and terminates when the user inputs ‘quit’
	•	Self-review – 
	◦	Correctness of method one: 90%, it does not work for extreme or hard factors. Likely a bug when the number is very large.
	◦	Correctness of method two: 90% the method doesn't work for negative numbers, and can be very slow for large numbers.
	◦	Correctness of main method: 95%. It can only accept numbers up to long format.
	•	Metadata –
	◦	Spent about 6 hours coding this assignment. I couldn’t figure out how to terminate the program when the user types “quit”. Even though I thought it would be easy to figure out, I actually spent quite a bit of time solving it. Turns out it was because of the order of the scanner input. 

