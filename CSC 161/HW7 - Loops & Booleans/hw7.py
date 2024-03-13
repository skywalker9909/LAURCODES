# -*- coding: utf-8 -*-
'''Laurel Tay Raeanne, Homework 7: Loops and Booleans'''

def get_input():
    userinput = input("Please enter a positive integer: ")
    try:
        userinput = int(userinput)
        if userinput < 0:
            print("The integer must be positive.")
            return
    except ValueError:
        print("Bad input!")
        return
    return userinput


def lagrange(n):
   
    x = int((n**0.5)+1)
    
    for i in range (x):
        for j in range (x):
            for k in range (x):
                for l in range (x):
                    if (i**2+j**2+k**2+l**2 == n):
                        return [i,j,k,l]
                    else:
                        continue 
                    
    
                    
def main():
    n = get_input()
    if n or n == 0:
        dobby = lagrange(n)
        print("{} {} {} {}".format(dobby[0], dobby[1], dobby[2], dobby[3]))
    else:
        main()

main()