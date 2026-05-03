#this program will only showcase the different random functions in the random module

import random #import the random module

def main():
    print(random.randint(1,10))
    #aks for a random integer value

    print(random.randrange(1,11,2))
    #is like randint except is acts like the range function returning a value from a range

    print(random.random)
    #will get a random floating-point number from 0.0 to 1.0 but not including 1.0

    print(random.uniform(1.0,10.0))
    #is like random.random except it is a range of value and does not include 10.0

main()
