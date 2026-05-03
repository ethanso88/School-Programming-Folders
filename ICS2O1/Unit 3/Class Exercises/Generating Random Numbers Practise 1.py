#This short program will display a random number between 1-10
#To do this we will call on a library function
#This library function is a value returning function that will return the value

import random #must import the random module to load the contents of the module to into pythons memory so it is available 

def main():
    number = random.randint(1,10)
    #to use functions in a module you add the name of the module on the left
    #and the name of the function on the right separated by a dot.

    #randint allows for two argument to pass through it for the range
    #and then it will ask for a random number in that range

    print(number)

main()
