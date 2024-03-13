# -*- coding: utf-8 -*-
'''Laurel Tay Raeanne, Homework 11'''


#def reverse(s):
#    okso = s[::-1]
#    print(s,"reversed is",(okso))
    
def reverse(s):
    if (len(s)) == 1:
        return s
    return reverse(s[1:]) + s[0]
        
def main():
    x = input("Enter the string to reverse: ")
    r = reverse(x)
    print(x, "reversed is", r)
    
main()

