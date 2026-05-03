#This program will simulates ten coin tosses, one after the other.
#Each time the program stimulates a coin toss, it will randomly display either “Heads” or “Tails”.

import random #import random module

def main():
    print('This program will simulate 10 coin tosses in a row')     #Intro
    
    for x in range (10):    #Loop ten times for 10 coin tosses
        if random.randint(1,2) == 1:    #if heads then print "Heads"
            print('Heads')
        
        else:
            print('Tails') #if not Heads then print "Tails"

main()

print()

#alternative solution
def alt():
    print('This program will simulate 10 coin tosses in a row')     #Intro
    
    for x in range (10):    #Loop ten times for 10 coin tosses
        number = random.randint(1,2)
        if number == 1:    #if heads then print "Heads"
            print('Heads')
        
        else:
            print('Tails') #if not Heads then print "Tails"
alt()
