 
'''Laurel Tay Raeanne, Homework 2: Numbers. Takes as input A and outputs estimated square root of A'''


import math

print("This program calculates the square root of a given number using the secant method.")
A = float(input("What is the number for which you want to calculate the square root? "))
x0 = A/5
x1 = A/10

z = int(input("How many iterations do you want to use? "))

for i in range(1,z+1):

    approx = x0-(((x0**2)-A)/(x0+x1))

    x1=x0
    x0=approx

    y = math.sqrt(A)
    n = abs(y-approx)

    print("{} {} {}" .format(i, approx, n))
        

print(f"My guess for the square root of {A} is {approx}")
print(f"The difference between my guess and the real result is {n}")

