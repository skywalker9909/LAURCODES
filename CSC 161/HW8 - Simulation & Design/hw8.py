'''Laurel Tay Raeanne, Homework 8: Simulation & Design'''


import random
import math


def main():
    
    random.seed(0)

    m = int(input("How many walks should I do? "))
    n = int(input("How many steps should I take on each? "))

    totaldistance = 0
    
    for i in range(m):
        a,b = random_walk_2d(n)
        totaldistance += distance(a,b)
        
    print("Average distance from start: {:.2f}".format(totaldistance/m))
    

def random_walk_2d(n):
    x = 0.0
    y = 0.0
    
    for i in range (n):
        r1 = random.random()
        if (r1 <= 0.25):
            y = y + 1
        if ( 0.25 <= r1 < 0.5 ):
            x = x + 1
        if ( 0.5 <= r1 < 0.75 ):
            y = y - 1
        if ( 0.75 <= r1 < 1 ):
            x = x - 1
            
    return x,y

def distance(a,b):
    p = [a,b]
    q = [0,0]
    distance = math.dist(p,q)
    return distance


main()