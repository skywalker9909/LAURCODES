'''Laurel Tay Raeanne, Homework 3: Functions'''


def square_each(nums):
    for i in range (0,len(nums)):
        squared = nums[i]**2
        nums[i]=squared

def sum_list(nums):
    sum = 0 
    for i in range (0,len(nums)):
            sum = sum + nums[i]
    return sum

def to_numbers(str_list):
    new_list = []
    for i in str_list:
        new_list.append(int(i))
    return new_list

def main():
    
    
    textinput = input("Please enter the file name: ")

    f = open(textinput,"r")
    
    data = f.read()
    
    str_list=data.split()
        
    nums = to_numbers(str_list)
    
    y = square_each(nums)
    z = sum_list(nums)

    print("The sum of the squares of the numbers in the file is",z)

main()
