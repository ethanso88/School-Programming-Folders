#This program will simulate rolling a pair of dice

import random #import random module

def main():
    print('This program will simulate rolling two dice and '+ \
          'will ask if you want to roll again.\n' \
          'Simply enter "y" if you want to roll again')
    
    again = 'y' #the control variable for the while loop 

    while again == 'y':  #While the user wants to roll the dice
        print('You rolled:')
        
        #Display a random number in the range of 1 to 6
        print('Die #1:', random.randint(1,6))
        
        #Display another random number in the range of 1 to 6
        print('Die #2:', random.randint(1,6))
        
        #Ask the user if they want to roll the dice again
        again = input('Do you want to roll the dice again? ')

main()
