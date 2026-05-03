#This program will generate 5 random numbers in the range of 1 through 100 using a loop

import random #import the random module 

def main():
    for x in range(5):
        print(random.randint(1,100))
        #the random.randint is in the print function and it will print the result of the function in the random module 
        #you can directly print a random number and don't need to assign a variable to random

main()
