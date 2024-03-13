# -*- coding: utf-8 -*-
"""
Created on Sun Dec 11 16:27:11 2022

@author: laure
"""



def reverse2(s):
    oklength = len(s)
    if oklength == 1:
        return s
    else: 
        return reverse2(s[:2])
    

def main():
    x = input("Enter the string to reverse: ")
    print (reverse2(x))
    
main()

    