#This program will play 5 trials of a guessing game between the user and the computer
#The rules of this guessing game are:
    #1)The computer will generate a random number and the user will have to guess what that number is.
        #The random number will be between 1 and 100 including 1 and 100
    #2)After the user guesses, Python will let them know if they guessed correctly, or if their guess is highr or lower than what the computer chose
    #3)The user will repeat guessing until 5 turns
    #4)If the user guesses before the 5 turns are used up, they win the game
    #5)If the user does not guess correctly after 5 turns have been used they lose the game

import random #to use the random functions to generate random numbers

def main():
    intro()
    
    number = random.randrange(1, 101) #the randomly generated number between 1 and 100

    total = 1 #sentinel value

    while total < 6: #while loop that will repeat up to 5 times
        guess = int(input('Guess the generated number: '))

        if guess < 1 or guess > 100:
            print('You did not enter a guess that can be used')
        elif guess > number:
            print('Your guess was higher than the number')
        elif guess < number:
            print('Your guess was lower than the number')
        elif guess == number:
            print('You got the number right!')
            print('You win!')
            total = 7 #to end the loop
        
        total += 1 #to start the next turn until the total reaches a value of 5 then the user loses

    if total == 6: #this will be when the while loop ends
        #This is set to = 6 so that this won't print when the user wins
        print('You lost the game, the computer wins')
        print('The number was:', number)
        

def intro():
    #This is the introduction to explain the game to the user
    print('This is a guessing game between the user and the computer')
    print('The rules of this guessing game are:')
    print('1)The computer will generate a random number and the user will have to guess what that number is.')
    print('\t', 'The random number will be between 1 and 100 including 1 and 100')
    print('2)After the user guesses, Python will let them know if they guessed correctly, or if their guess is highr or lower than what the computer chose')
    print('3)The user will repeat guessing until 5 turns')
    print('4)If the user guesses before the 5 turns are used up, they win the game')
    print('5)If the user does not guess correctly after 5 turns have been used they lose the game')
    print()

main()

