#This program will play a round of rock paper scissors 
#The users will input their selection of rock, paper or scissors
#The computer will also generate a selection
#The program will then display the winner of the round or if it is a draw

import random #import the random module

def main():
    again = 'y' #loop controlling variable
    
    #brief intro
    print('This program will allow one person to play a game of rock, paper, scissors against the computer')
    print('Please input "rock", "paper" or "scissors"\n')

    while again == 'y' or again == 'yes' or again == 'Y' or again == 'Yes':
        #input
        player = input('Enter your choice here: ')

        #computer choice
        computer = random.randint(1,3)
        # 1 = rock, 2 = paper, 3 = scissors
        
        #to determine the winner
        winner(player, computer)

        again = input('Would you like to play again? ')

def winner(player, computer):
    
    #possible outputs and possibilities for rock 
    if player == 'rock':
        #rock and rock is a tie
        if computer == 1:
            print('The round is a tie')

        #paper wins against rock so the computer wins
        elif computer == 2:
            print('The computer wins this round')

        #rock wins against scissors so the player wins
        elif computer == 3:
            print('The player wins this round')

    #then the outcomes of paper
    elif player == 'paper':
        if computer == 1:
            print('The player wins this round')

        elif computer == 2:
            print('The round is a tie')

        elif computer == 3:
            print('the computer wins this round')

    #then the outcomes of scissors
    elif player == 'scissors':
        if computer == 1:
            print('The computer wins this round')

        elif computer == 2:
            print('The player wins this round')

        elif computer == 3:
            print('The round is a tie')

    #if player1 doesn't input rock, paper, or scissors
    else:
        print("The player didn't input a possible choice, please try again with a possible choice")

main()



    
    
